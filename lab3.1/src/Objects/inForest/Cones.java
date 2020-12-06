package Objects.inForest;

public class Cones {
    private String thrown;
    private String threw;

    public Cones(String threw, String thrown) {
        this.threw = threw;
        this.thrown = thrown;
    }

    public void beThrow(Cones cone) {
        System.out.println(cone);
    }

    @Override
    public String toString() {
        return threw + " бросил шишкой в " + thrown;
    }
}
