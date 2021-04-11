package data;

import java.io.Serializable;

/**
 * Chapter with marines.
 */
public class Chapter implements Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;
    private Long marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000
    private String world; //Поле может быть null

    public Chapter(String name, String parentLegion, Long marinesCount, String world) {
        this.name = name;
        this.parentLegion = parentLegion;
        this.marinesCount = marinesCount;
        this.world = world;
        checkParentLegion();
        checkWorld();
    }

    public void checkParentLegion() {
        if (parentLegion.equals("")) {
            parentLegion = "отсутсвует";
        }
    }

    public void checkWorld() {
        if (world.equals("")) {
            world = "не задан";
        }
    }

    @Override
    public int hashCode() {
        return marinesCount.hashCode();
    }

    @Override
    public String toString() {
        return
                "Имя главы: " + name + "\n" +
                        "Легион: " + parentLegion + "\n" +
                        "Количество морских пехотинцев: " + marinesCount + "\n" +
                        "Мир: " + world;
    }
}
