package exchange;

import commands.Command;

import java.io.Serializable;

public class ExchangeOfCommands implements Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    Command command;
    String argument;

    public ExchangeOfCommands(Command command, String argument) {
        this.command = command;
        this.argument = argument;
    }

    public Command getCommand() {
        return command;
    }

    public String getArgument() {
        return argument;
    }
}