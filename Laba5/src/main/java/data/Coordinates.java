package data;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -56, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Double x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return
                "x=" + x +" "+
                "y=" + y ;
    }
}
