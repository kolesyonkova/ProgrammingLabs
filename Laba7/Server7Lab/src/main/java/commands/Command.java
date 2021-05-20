package commands;

/**
 * Interface for all commands.
 */
public interface Command {
    String execute(String argument);

    String getName();
}
