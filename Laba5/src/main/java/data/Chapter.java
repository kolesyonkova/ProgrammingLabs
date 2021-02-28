package data;

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
    public String toString() {
        return
                "Имя главы: " + name + "\n" +
                        "Легион: " + parentLegion + "\n" +
                        "Количество морских пехотинцев: " + marinesCount + "\n" +
                        "Мир: " + world;
    }
}
