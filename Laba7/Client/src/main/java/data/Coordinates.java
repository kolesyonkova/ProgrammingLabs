package data;

import java.io.Serializable;

/**
 * Coordinates of marine.
 */

public class Coordinates implements Serializable {
    private static final long serialVersionUID = 1L;
    private Double x; //Значение поля должно быть больше -56, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Double x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x.hashCode() + y.hashCode();
    }

    @Override
    public String toString() {
        return
                "x=" + x + " " +
                        "y=" + y;
    }
    public String toCsv() {
        return x + "," + y;
    }

}
