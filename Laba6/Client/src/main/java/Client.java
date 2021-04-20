import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private static SocketChannel client;
    private ByteBuffer data;

    public void start() {
        try {
            System.out.println("Starting client...");
            client = SocketChannel.open(new InetSocketAddress("localhost", 8089));
            String request = "some request";
            data = ByteBuffer.allocate(1024);
            TestClass testClass = new TestClass();
            testClass.setName("IVan");
            testClass.setSomething("lol");
            writeObject(testClass);
            readObject();
            testClass.setName("Geog");
            writeObject(testClass);
            readObject();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeObject(TestClass testClass) throws IOException {
        data = ByteBuffer.allocate(1024);
        data.put(serialize(testClass));
        data.flip();
        client.write(data);
    }
    public void readObject() throws IOException, ClassNotFoundException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        client.read(byteBuffer);
        TestClass testClass=deserialize(byteBuffer.array());
        System.out.println(testClass.getName());
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
