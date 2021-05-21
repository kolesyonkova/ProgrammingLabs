package commands;

import exceptions.WrongArgumentException;

/**
 * Command 'history'. Displays the latest commands.
 */
public class HistoryCommand extends AbstractCommand implements Command {
    public HistoryCommand() {
        super("history", "вывести последние 9 команд (без их аргументов)");
    }

    /**
     * Execute of 'history' command.
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
