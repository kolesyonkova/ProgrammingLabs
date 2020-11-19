package Objects;

public class Cup {
    private boolean isEmpty;

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public void fillTheCup() {
        isEmpty = true;
    }

    public void drankCup() {
        isEmpty = false;
    }
}
