package DAO;

import data.Chapter;
import data.Coordinates;
import data.MeleeWeapon;
import data.SpaceMarine;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DAOSpaceMarine {
    Connection connection;

    public DAOSpaceMarine(Connection connection) {
        this.connection = connection;
    }

    public void clear() {
        try (PreparedStatement statement = connection.prepareStatement(SQLQuery.CLEAR.QUERY)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeByID(String argument) {
        try (PreparedStatement statement = connection.prepareStatement(SQLQuery.REMOVE_BY_ID.QUERY)) {
            statement.setLong(1, Long.parseLong(argument));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int create(SpaceMarine spaceMarine) {
        int result = 0;
        try (PreparedStatement statement = connection.prepareStatement("insert into \"SpaceMarine\"(id,name, coordinateX, coordinateY,creation_date, health, heartCount, achievement, meleeWeapon, chapterName,parentLegion, marinesCount, world, userCreateId) values (default, (?),(?) ,(?), (?), (?), (?), (?), (?), (?), (?), (?),(?), 1)")) {
            SetTOUpdate(spaceMarine, statement);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Stack<SpaceMarine> read() {
        List<SpaceMarine> spaceMarineList = new ArrayList<>();
        ArrayList<Long> longArrayList = listOfID();
        Stack<SpaceMarine> spaceMarines = new Stack<>();


        for (Long numberMarine : longArrayList
        ) {
            try (PreparedStatement statement = connection.prepareStatement("SELECT * from \"SpaceMarine\" where id=(?)")) {
                statement.setInt(1, Math.toIntExact(numberMarine));
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    spaceMarineList.add(getSpaceMarine(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        spaceMarines.clear();
        spaceMarines.addAll(spaceMarineList);
        spaceMarineList.clear();
        return spaceMarines;
    }

    public SpaceMarine getSpaceMarine(ResultSet resultSet) throws SQLException {
        SpaceMarine marine = new SpaceMarine(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                new Coordinates(resultSet.getDouble("coordinateX"), resultSet.getInt("coordinateY")),
                LocalDate.now(),
                resultSet.getInt("health"),
                resultSet.getInt("heartCount"),
                resultSet.getString("achievement"),
                MeleeWeapon.valueOf(resultSet.getString("meleeWeapon")),
                new Chapter(resultSet.getString("chapterName"),
                        resultSet.getString("parentLegion"),
                        Long.parseLong(String.valueOf(resultSet.getInt("marinesCount"))),
                        resultSet.getString("world")));
        return marine;
    }

    public void update(SpaceMarine spaceMarine, Long id) {
        try (PreparedStatement statement = connection.prepareStatement("Update \"SpaceMarine\" SET name=(?), coordinateX=(?), coordinateY=(?),creation_date=(?), health=(?), heartCount=(?), achievement=(?), meleeWeapon=(?), chapterName=(?),parentLegion=(?), marinesCount=(?), world=(?) WHERE id=(?)")) {
            SetTOUpdate(spaceMarine, statement);
            System.out.println(id);
            statement.setLong(13, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void SetTOUpdate(SpaceMarine spaceMarine, PreparedStatement statement) throws SQLException {
        statement.setString(1, spaceMarine.getName());
        statement.setBigDecimal(2, BigDecimal.valueOf(spaceMarine.getCoordinates().getX()));
        statement.setInt(3, spaceMarine.getCoordinates().getY());
        statement.setString(4, String.valueOf(spaceMarine.getCreationDate()));
        statement.setInt(5, spaceMarine.getHealth());
        statement.setInt(6, spaceMarine.getHeartCount());
        statement.setString(7, spaceMarine.getAchievements());
        statement.setString(8, String.valueOf(spaceMarine.getMeleeWeapon()));
        statement.setString(9, spaceMarine.getChapter().getName());
        statement.setString(10, spaceMarine.getChapter().getParentLegion());
        statement.setInt(11, spaceMarine.getChapter().getMarinesCount());
        statement.setString(12, spaceMarine.getChapter().getWorld());
    }

    public ArrayList listOfID() {
        ArrayList<Long> idList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT id from \"SpaceMarine\"")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                idList.add(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idList;
    }

    public int countOfElements() {
        Integer countOfElements = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT count(*) FROM \"SpaceMarine\"")) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String res = resultSet.getString("count");
                countOfElements = Integer.parseInt(res);
            }
            return countOfElements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countOfElements;
    }

    private enum SQLQuery {
        REMOVE_BY_ID("DELETE FROM \"SpaceMarine\" WHERE id=(?)"),
        CLEAR("DELETE FROM \"SpaceMarine\"");
        String QUERY;

        SQLQuery(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
