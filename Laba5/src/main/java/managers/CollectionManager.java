package managers;

import data.SpaceMarine;

import java.time.LocalDate;
import java.util.EmptyStackException;
import java.util.Stack;

public class CollectionManager {
    private LocalDate initializationDate;
    private Stack<SpaceMarine> marineStack = new Stack<>();
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void addToCollection(SpaceMarine spaceMarine) {
        marineStack.push(spaceMarine);
    }

    public Long generateId() {
        if (!marineStack.empty()) {
            return marineStack.peek().getId() + 1;
        }
        return 1L;
    }

    public void loadCollectionFromStartFile() {
        marineStack = fileManager.loader();
        initializationDate = LocalDate.now();

    }


    public Stack<SpaceMarine> getMarineStack() {
        return marineStack;
    }

    public void showCollection() {
        try {

            for (SpaceMarine marines : marineStack) {
                System.out.println(marines);
            }
        } catch (EmptyStackException e) {
            System.out.println("Пустая коллекциия, обратитесь к ней после добавления элементов");
        }
    }
}
