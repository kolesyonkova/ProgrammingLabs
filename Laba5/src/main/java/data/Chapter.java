package data;

import java.util.Objects;

public class Chapter {
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
    }

    public void checkParentLegion() {
        if (parentLegion.equals("")) {
            parentLegion = "отсутсвует";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(name, chapter.name) &&
                Objects.equals(parentLegion, chapter.parentLegion) &&
                Objects.equals(marinesCount, chapter.marinesCount) &&
                Objects.equals(world, chapter.world);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion, marinesCount, world);
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
