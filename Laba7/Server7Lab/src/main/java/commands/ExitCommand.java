package commands;

import exceptions.WrongArgumentException;

/**
 * Command 'exit'. Exits the program.
 */
public class ExitCommand extends AbstractCommand implements Command {
    public ExitCommand() {
        super("exit", " завершить программу (без сохранения в файл)");
    }

    /**
     * Execute of 'exit' command.
     * @return
     */
    @Override
    public String execute(String argument) {
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
        return argument;
    }
}