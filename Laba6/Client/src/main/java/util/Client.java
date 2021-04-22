package util;

import data.SpaceMarine;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private static int valueOfByteBuffer=65536;
    private static SocketChannel client;
    private static ByteBuffer data;

    public static void start() {
        try {
            System.out.println("Starting client...");
            client = SocketChannel.open(new InetSocketAddress("localhost", 8089));
            String request = "some request";
            data = ByteBuffer.allocate(valueOfByteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(ExchangeClass testClass) throws IOException, ClassNotFoundException {
        data = ByteBuffer.allocate(valueOfByteBuffer);
        data.put(serialize(testClass));
        data.flip();
        client.write(data);
        readObject();
    }

    public static void readObject() throws IOException, ClassNotFoundException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(valueOfByteBuffer);
        client.read(byteBuffer);
        ExchangeClass testClass = deserialize(byteBuffer.array());
        System.out.println(testClass.getAnswer());
    }

    public static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }

    public static ExchangeClass deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream b = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream o = new ObjectInputStream(b)) {
                return (ExchangeClass) o.readObject();
            }
        }
    }

    public static void readyToExchange(String name, String argument, SpaceMarine spaceMarine) throws IOException, ClassNotFoundException {
        ExchangeClass exchangeClass = new ExchangeClass();
        exchangeClass.setName(name);
        exchangeClass.setArgument(argument);
        exchangeClass.setSpaceMarine(spaceMarine);
        writeObject(exchangeClass);
    }

}
