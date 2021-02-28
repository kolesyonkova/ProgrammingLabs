package data;

import java.time.LocalDate;

public class SpaceMarine {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long health; //Значение поля должно быть больше 0
    private Integer heartCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 3
    private String achievements; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

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
    }


    public Long getId() {
        return id;
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
}
