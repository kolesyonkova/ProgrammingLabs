package util;

import data.SpaceMarine;

import java.io.Serializable;

public class ExchangeClass implements Serializable {
    private static final long serialVersionUID = 1L;
    String nameOfCommand;
    String argument;
    SpaceMarine spaceMarine;
    String answer;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return nameOfCommand;
    }

    public void setName(String nameOfCommand) {
        this.nameOfCommand = nameOfCommand;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public SpaceMarine getSpaceMarine() {
        return spaceMarine;
    }

    public void setSpaceMarine(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ExchangeClass{" +
                "nameOfCommand='" + nameOfCommand + '\'' +
                ", argument='" + argument + '\'' +
                ", spaceMarine=" + spaceMarine +
                ", answer='" + answer + '\'' +
                '}';
    }
}
