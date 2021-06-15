package util;

import data.SpaceMarine;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private static final int valueOfByteBuffer = 65536;
    private static SocketChannel client;
    private static ByteBuffer data;
    private static User user;
    private static String answer;

    public static void start() {
        try {
            System.out.println("Starting client...");
            client = SocketChannel.open(new InetSocketAddress("localhost", 8088));
            data = ByteBuffer.allocate(valueOfByteBuffer);
            System.out.println("Клиент подключился к серверу");
        } catch (ConnectException e) {
            System.out.println("Невозможно подключиться! Реконнект через 5 произойдёт");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(ExchangeClass testClass) {
        try {
            data = ByteBuffer.allocate(valueOfByteBuffer);
            data.put(serialize(testClass));
            data.flip();
            client.write(data);
            readObject();
        } catch (IOException e) {
            System.out.println("Сервер отключён. Пытаюсь переподключиться...");
            start();
            writeObject(testClass);
        }
    }

    public static void readObject() {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(valueOfByteBuffer);
            client.read(byteBuffer);
            ExchangeClass testClass = deserialize(byteBuffer.array());
            System.out.println(testClass.getAnswer());
            setAnswer(testClass.getAnswer());
            if (testClass.getAnswer().equals("Такого пользователя не существует.Повторите попытку")) setUser(null);
            if (testClass.getAnswer().equals("Пользователь уже в сети, вы не можете войти. Завершите все другие сессии, чтобы войти"))
                setUser(null);
        } catch (ClassNotFoundException e) {
            System.out.println("Что-то пошло не так с записью! Клиент");
        } catch (IOException e) {
            System.out.println("Сервер отключён. Пытаюсь переподключиться...");
            start();
        }
    }

    public static String getAnswer() {
        return answer;
    }

    private static void setAnswer(String answer1) {
        answer = answer1;
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

    public static void readyToExchange(String name, String argument, SpaceMarine spaceMarine) {
        ExchangeClass exchangeClass = new ExchangeClass();
        exchangeClass.setName(name);
        exchangeClass.setArgument(argument);
        exchangeClass.setSpaceMarine(spaceMarine);
        exchangeClass.setUser(user);
        writeObject(exchangeClass);
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Client.user = user;
    }

    public static void readyToExchange(String name, String argument, SpaceMarine spaceMarine, User user) {
        setUser(user);
        ExchangeClass exchangeClass = new ExchangeClass();
        exchangeClass.setName(name);
        exchangeClass.setArgument(argument);
        exchangeClass.setSpaceMarine(spaceMarine);
        exchangeClass.setUser(user);
        writeObject(exchangeClass);
    }
}
