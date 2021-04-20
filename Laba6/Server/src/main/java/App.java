import java.nio.channels.Selector;

public class App {
    private static Selector selector = null;

    public static void main(String[] args) throws ClassNotFoundException {
       Server server=new Server();
       server.start();
    }
}
