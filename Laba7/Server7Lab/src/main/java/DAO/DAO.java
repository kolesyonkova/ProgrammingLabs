package DAO;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DAO {

    private static Scanner scanner;

    static {
        try {
            scanner = new Scanner(Paths.get("C:\\Users\\kater\\Desktop\\DataForHelios.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String login = scanner.nextLine();
    private static String password = scanner.nextLine();
    private static final ConnectionToDatabase connectionToDatabase = new ConnectionToDatabase(login, password);
    private static final DAOSpaceMarine daoSpaceMarine = new DAOSpaceMarine(connectionToDatabase.getConnection());

    public static DAOSpaceMarine getDaoSpaceMarine() {
        return daoSpaceMarine;
    }
}
