import commands.*;
import exchange.ExchangeOfCommands;
import managers.CollectionManager;
import managers.CommandManager;
import managers.ConsoleManager;
import managers.FileManager;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class App {
    private static Selector selector = null;

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        final String myenv = "WC_FILE";
        FileManager fileManager = new FileManager(myenv);
        ToExchange toExchange = new ToExchange();
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
        try {
            selector = Selector.open();
//            We have to set connection host, port and non-blocking mode
            ServerSocketChannel socket = ServerSocketChannel.open();
            ServerSocket serverSocket = socket.socket();
            serverSocket.bind(new InetSocketAddress("localhost", 3000));
            System.out.println("Server started!");
            socket.configureBlocking(false);
            int ops = socket.validOps();
            socket.register(selector, ops, null);
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> i = selectedKeys.iterator();

                while (i.hasNext()) {
                    SelectionKey key = i.next();

                    if (key.isAcceptable()) {
//                        New client has been accepted
                        handleAccept(socket, key);
                    } else if (key.isReadable()) {
//                        We can run non-blocking operation READ on our client
                        ExchangeOfCommands exchange = consoleManager.userMode(handleRead(key));
                        toExchange.setExchangeOfCommands(exchange);
                    } else if (key.isWritable()) {
//                        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("somefile"));
//                        ExchangeOfCommands exchangeOfCommands1 = (ExchangeOfCommands) objectInputStream.readObject();
//                        System.out.println(exchangeOfCommands1.getAnswer());
                        handleWrite(key, toExchange.getExchangeOfCommands());
                    }
                    i.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(ServerSocketChannel mySocket,
                                     SelectionKey key) throws IOException {

        System.out.println("Connection Accepted...");

        // Accept the connection and set non-blocking mode
        SocketChannel client = mySocket.accept();
        client.configureBlocking(false);

        // Register that client is reading this channel
        client.register(selector, SelectionKey.OP_READ);
    }

    private static ExchangeOfCommands handleRead(SelectionKey key)
            throws IOException, ClassNotFoundException {
        System.out.println("Reading...");
        // create a ServerSocketChannel to read the request
        SocketChannel client = (SocketChannel) key.channel();

        // Create buffer to read data
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        client.read(byteBuffer);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteBuffer.array()));
        client.register(key.selector(), SelectionKey.OP_WRITE);
        return (ExchangeOfCommands) objectInputStream.readObject();
    }

    private static void handleWrite(SelectionKey key, ExchangeOfCommands exchange)
            throws IOException, ClassNotFoundException {
        System.out.println("Writing...");
        // create a ServerSocketChannel to read the request
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(exchange);
        objectOutputStream.flush();
        client.write(byteBuffer);
        client.register(key.selector(), SelectionKey.OP_READ);
    }
}
