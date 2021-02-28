package commands;

import exceptions.WrongArgumentException;

public class ExitCommand extends AbstractCommand implements Command {
    public ExitCommand() {
        super("exit", " завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            System.out.println("Программа успешно завершена!");
            System.exit(0);
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}