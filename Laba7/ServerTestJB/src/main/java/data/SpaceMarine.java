package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Main character. Is stored in the collection.
 */
public class SpaceMarine implements Comparable<SpaceMarine>, Serializable {
    private static final long serialVersionUID = 1L;
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long health; //Значение поля должно быть больше 0
    private Integer heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private String achievements; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(Long id, String name, Coordinates coordinates, LocalDate creationDate, long health, Integer heartCount, String achievements, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.achievements = achievements;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
        checkAchievements();
    }

    public SpaceMarine(String name, Coordinates coordinates, LocalDate creationDate, long health, Integer heartCount, String achievements, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.heartCount = heartCount;
        this.achievements = achievements;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
        checkAchievements();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void checkAchievements() {
        if (achievements.equals("")) {
            achievements = "отсутсвуют";
        }
    }

    public Long getId() {
        return id;
    }

    public boolean isEmpty() {
        return (this.name == null || this.id == null || this.coordinates == null || this.creationDate == null || this.heartCount == null || this.achievements == null || this.meleeWeapon == null || this.chapter == null || this.health == 0L);
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Integer getHeartCount() {
        return heartCount;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine that = (SpaceMarine) o;
        return health == that.health &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(coordinates, that.coordinates) &&
                Objects.equals(creationDate, that.creationDate) &&
                Objects.equals(heartCount, that.heartCount) &&
                Objects.equals(achievements, that.achievements) &&
                meleeWeapon == that.meleeWeapon &&
                Objects.equals(chapter, that.chapter);
    }

    public int getHealth() {
        return Math.toIntExact(health);
    }

    public String getAchievements() {
        return achievements;
    }

    @Override
    public int hashCode() {
        return (int) (coordinates.hashCode() + health + heartCount.hashCode() + chapter.hashCode());
    }

    @Override
    public String toString() {
        return
                "Солдат №" + id + "\n" +
                        "Имя: " + name + "\n" +
                        "координаты: " + coordinates + "\n" +
                        "Дата создания: " + creationDate + "\n" +
                        "Здоровье: " + health + "\n" +
                        "Количество сердечных сокращений: " + heartCount + "\n" +
                        "Достижения: " + achievements + "\n" +
                        "Оружие ближнего боя: " + meleeWeapon + "\n" +
                        chapter;
    }


    @Override
    public int compareTo(SpaceMarine compareMarine) {
        return (int) (this.getHealth() - compareMarine.getHealth());
    }

    public String toCsv() {
        return name + "," + coordinates.toCsv() + "," + health + "," + heartCount + "," + achievements + "," + meleeWeapon + "," + chapter.toCsv();
    }
}
