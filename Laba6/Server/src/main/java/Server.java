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

public class Server {
    private static Selector selector = null;

    public void start() throws ClassNotFoundException {
        try {
            selector = Selector.open();
            ServerSocketChannel socket = ServerSocketChannel.open();
            ServerSocket serverSocket = socket.socket();
            System.out.println("Server is started...");
            serverSocket.bind(new InetSocketAddress("localhost", 8089));
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
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleAccept(ServerSocketChannel mySocket,
                                     SelectionKey key) throws IOException {

        System.out.println("Connection Accepted...");
        SocketChannel client = mySocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private void handleRead(SelectionKey key)
            throws IOException, ClassNotFoundException {
        System.out.println("Reading...");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        client.read(byteBuffer);
        TestClass testClass=deserialize(byteBuffer.array());
        System.out.println(testClass.getName());
        client.register(selector, SelectionKey.OP_WRITE);
    }

    private void handleWrite(SelectionKey key)
            throws IOException {
        System.out.println("Writing...");
        TestClass testClass=new TestClass();
        testClass.setName("Otvet");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(serialize(testClass));
        buffer.flip();
        client.write(buffer);
        client.register(selector, SelectionKey.OP_READ);
    }
    public byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }

    public TestClass deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream b = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream o = new ObjectInputStream(b)) {
                return (TestClass) o.readObject();
            }
        }
    }
}
