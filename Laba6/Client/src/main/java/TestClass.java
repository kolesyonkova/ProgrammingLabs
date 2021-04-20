import java.io.Serializable;

public class TestClass implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    String something;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }
}
