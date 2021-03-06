package DAO;

import org.postgresql.util.PSQLException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
    private static java.sql.Connection connection;

    public ConnectionToDatabase(String login, String password) {
        this.login = login;
        this.password = password;
        try {
            connectToDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private String login;
    private String password;
    private String url = "jdbc:postgresql://localhost:8086/studs";
    //private static final String url = "jdbc:postgresql://pg:5432/studs";

    public void connectToDatabase() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
        }
        try {
            connection = DriverManager.getConnection(url, login, password);
            setConnection(connection);
            System.out.println("PostgreSQL JDBC Driver successfully connected");
        } catch (PSQLException e) {
            System.out.println("Проблемы с подключением к базе данных. Повторите попытку позже.");
            System.exit(-1);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        ConnectionToDatabase.connection = connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private String hashPassword(String password) {
        String sha256 = password;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            sha256 = new String(md.digest(password.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Problem with hashing! Password isn't hashed");
        }
        return sha256;
    }
}

