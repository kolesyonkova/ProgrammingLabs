package commands;

import exceptions.WrongArgumentException;
import managers.CommandManager;

public class HelpCommand extends AbstractCommand implements Command {
    CommandManager commandManager;

    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public void execute(String argument) {
        try {
            System.out.println("Hello from HelpCommand");
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        }catch (Exception e){
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
