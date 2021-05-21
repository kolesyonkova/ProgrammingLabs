package DAO;

import util.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUser {
    Connection connection;

    public DAOUser(Connection connection) {
        this.connection = connection;
    }

    public String create(User user) {
        int result = 0;
        try (PreparedStatement statement = connection.prepareStatement(SQLQuery.INSERT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, encryptString(user.getPassword()));
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return String.valueOf(result);
    }

    public String login(User user) throws SQLException {
        String res = null;
        try (PreparedStatement statement = connection.prepareStatement(SQLQuery.SELECT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, encryptString(user.getPassword()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                res = resultSet.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private enum SQLQuery {
        INSERT("insert into \"User\"(login, password) values ((?),(?))"),
        SELECT("select id from \"User\" where login=(?) and password=(?)");
        String QUERY;

        SQLQuery(String QUERY) {
            this.QUERY = QUERY;
        }
    }

    public static String encryptString(String string) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(string.getBytes(StandardCharsets.UTF_8));
            BigInteger numRepresentation = new BigInteger(1, digest);
            String hashedString = numRepresentation.toString(16);
            while (hashedString.length() < 32) {
                hashedString = "0" + hashedString;
            }
            return hashedString;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm.");
        }
        return null;
    }
}
