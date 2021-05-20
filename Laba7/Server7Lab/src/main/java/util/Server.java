package util;

import managers.Asker;
import managers.CollectionManager;
import managers.CommandManager;
import managers.FileManager;

import java.io.*;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Server {
    private static Selector selector = null;
    private static int valueOfByteBuffer = 65536;
    Handler handler;

    public Server(Scanner userScanner, String myenv, CollectionManager collectionManager, FileManager fileManager, Asker asker, CommandManager commandManager) {
        this.handler = new Handler(userScanner, myenv, collectionManager, fileManager, asker, commandManager);
    }

    public void start() {
        try {
            selector = Selector.open();
            ServerSocketChannel socket = ServerSocketChannel.open();
            ServerSocket serverSocket = socket.socket();
            System.out.println("Server is started...");
            serverSocket.bind(new InetSocketAddress("localhost", 8088));
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
                        handleAccept(socket, key);
                    } else if (key.isReadable()) {
                        handleRead(key);
                    } else if (key.isWritable()) {
                        handleWrite(key);
                    }
                    i.remove();
                }
            }
        } catch (BindException e) {
            System.out.println("Порт занят попробуйте смените значение порта в программе");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Произошли проблемы со стартом сервера. Попробуйте снова через некоторое время.");
            System.exit(-1);
        }
    }

    private static void handleAccept(ServerSocketChannel mySocket,
                                     SelectionKey key) throws IOException {

        System.out.println("Соединение Принято...");
        SocketChannel client = mySocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private void handleRead(SelectionKey key) {
        System.out.println("Чтение...");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(valueOfByteBuffer);
        try {
            client.read(byteBuffer);
            ExchangeClass exchangeClass = deserialize(byteBuffer.array());
            System.out.println(exchangeClass);
            Exchanger.setExchangeClass(Handler.startCommand(exchangeClass));
            client.register(selector, SelectionKey.OP_WRITE);
        } catch (IOException | ClassNotFoundException e) {
            try {
                client.close();
            } catch (IOException e1) {
                System.out.println("Что-то пошло не так. Server Handle Read.");
            }
            System.out.println("Клиент отключился");
        }
    }


    private void handleWrite(SelectionKey key) {
        System.out.println("Запись...");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(valueOfByteBuffer);
        try {
            buffer.put(serialize(Exchanger.getExchangeClass()));
            buffer.flip();
            client.write(buffer);
            client.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            try {
                client.close();
            } catch (IOException e1) {
                System.out.println("Что-то пошло не так. Server Handle Read.");
            }
            System.out.println("Клиент отключился");
        }
    }

    public byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }

    public ExchangeClass deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream b = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream o = new ObjectInputStream(b)) {
                return (ExchangeClass) o.readObject();
            }
        }
    }
}
