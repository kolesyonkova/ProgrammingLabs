package commands;

import exceptions.WrongArgumentException;

import java.io.Serializable;

/**
 * Command 'help'. Displays help for available commands.
 */
public class HelpCommand extends AbstractCommand implements Command, Serializable {
    private static final long serialVersionUID = 8983558202217591746L;
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    /**
     * Execute of 'help' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
