package Objects;

public class Chair {
    private String thrown;
    private String threw;

    public Chair(String threw, String thrown, int count) {
        this.threw = threw;
        this.thrown = thrown;
    }

    public void beThrow(Chair chair) {
        System.out.println(chair);
    }

    @Override
    public String toString() {
        return threw + " бросил шишкой в " + thrown;
    }
}
