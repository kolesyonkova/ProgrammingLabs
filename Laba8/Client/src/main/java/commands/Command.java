package commands;

/**
 * Interface for all commands.
 */
public interface Command {
    void execute(String argument);

    String getName();
}
