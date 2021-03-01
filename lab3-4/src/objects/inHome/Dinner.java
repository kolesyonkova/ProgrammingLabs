package objects.inHome;

public class Dinner {
    private boolean isDinner = true;

    public void setDinner() {
        isDinner = true;
    }

    public void overDinner() {
        isDinner = false;
    }

    public boolean getCondition() {
        return isDinner;
    }
}