package managers;

import commands.Command;
import commands.ShowCommand;
import exchange.ExchangeOfCommands;
import managers.CollectionManager;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Client {
    private Socket clientSocket;
    private int port;
    private String host;
    CollectionManager collectionManager;
    private ByteBuffer byteBuffer=ByteBuffer.allocate(65536);

    private static ObjectInputStream in;
    private static ObjectOutputStream out;


    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            clientSocket = new Socket(host, port);
            start();
        } catch (IOException e) {
            System.out.println("Не удалось подключиться к серверу. Попробуйте ещё раз сменив порт.");
        }
    }

    public void start() {
        System.out.println("Подключение к серверу прошло успешно!");
    }

    public void readFromServer() throws IOException {
        in = new ObjectInputStream((clientSocket.getInputStream()));
    }

    public void writeToServerCollection() throws IOException {
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        out.writeObject(collectionManager.getMarineStack());
    }

    public void writeToServerCommand(Command command,String argument) throws IOException, ClassNotFoundException {
        OutputStream outputStream = clientSocket.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream= new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(new ExchangeOfCommands(command,argument));
        objectOutputStream.flush();
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
    }
}
