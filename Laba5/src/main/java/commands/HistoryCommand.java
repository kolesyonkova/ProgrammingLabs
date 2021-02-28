package commands;

import exceptions.WrongArgumentException;

public class HistoryCommand extends AbstractCommand implements Command {
    public HistoryCommand() {
        super("history", "вывести последние 9 команд (без их аргументов)");
    }

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
