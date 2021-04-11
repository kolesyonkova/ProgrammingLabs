import commands.*;
import exchange.ExchangeOfCommands;
import managers.CollectionManager;
import managers.CommandManager;
import managers.ConsoleManager;
import managers.FileManager;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final String myenv = "WC_FILE";
        FileManager fileManager = new FileManager(myenv);

        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(new AddCommand(collectionManager),
                new ClearCommand(collectionManager),
                new GroupCountingByIdCommand(collectionManager),
                new ShowCommand(collectionManager),
                new SaveCommand(collectionManager, fileManager),
                new HelpCommand(),
                new HistoryCommand(),
                new InfoCommand(collectionManager),
                new RemoveAllByHealthCommand(collectionManager),
                new RemoveAnyByAchievementsCommand(collectionManager),
                new RemoveFirstCommand(collectionManager),
                new RemoveGreaterCommand(collectionManager),
                new UpdateCommand(collectionManager),
                new ExitCommand(),
                new RemoveById(collectionManager));
        ConsoleManager consoleManager = new ConsoleManager(commandManager, fileManager);
        collectionManager.loadCollectionFromStartFile();
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(3000));
        serverSocketChannel.configureBlocking(false);
        System.out.println("Сервер стартовал!");
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer byteBuffer = ByteBuffer.allocate(65536);
//        ExchangeOfCommands exchangeOfCommands1= new ExchangeOfCommands(new ShowCommand(collectionManager), "");
//        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream("somefile"));
//        objectOutputStream1.writeObject(exchangeOfCommands1);
//        System.out.println("Записал!");
//        ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("somefile"));
//        ExchangeOfCommands exchangeOfCommands2 = (ExchangeOfCommands) objectInputStream1.readObject();
//        System.out.println(exchangeOfCommands2);
        while (true) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
            while (selectedKeys.hasNext()) {
                SelectionKey k = selectedKeys.next();
                if (k.isValid()) {
                    if (k.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        System.out.println("Клиент присоединился!");
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (k.isReadable()) {
                        ((SocketChannel) k.channel()).read(byteBuffer);
                        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer.array()));
                        ExchangeOfCommands exchangeOfCommands = (ExchangeOfCommands) objectInputStream.readObject();
                        System.out.println(exchangeOfCommands);
                        consoleManager.userMode(exchangeOfCommands);
                        byteBuffer.clear();
                        SocketChannel socketChannel = (SocketChannel) k.channel();
                        socketChannel.register(selector, SelectionKey.OP_WRITE);
                        socketChannel.configureBlocking(false);
                    } else if (k.isWritable()) {
                        ((SocketChannel) k.channel()).write(byteBuffer);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        objectOutputStream.writeObject("");
                    }
                    selectedKeys.remove();

                } else {
                    continue;
                }
            }

        }
    }
}
