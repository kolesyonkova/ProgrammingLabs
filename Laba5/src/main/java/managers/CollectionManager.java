package managers;

import data.SpaceMarine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Class for operation on collection.
 */
public class CollectionManager {
    private LocalDate initializationDate;
    private LocalDate lastUpdate;
    private Stack<SpaceMarine> marineStack = new Stack<>();
    private ArrayList<SpaceMarine> tmpMarine = new ArrayList<>();
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /**
     * add into collection element
     *
     * @param spaceMarine -element
     */
    public void addToCollection(SpaceMarine spaceMarine) {
        marineStack.push(spaceMarine);
        lastUpdate = LocalDate.now();
    }

    /**
     * Update collection
     *
     * @param spaceMarine -new marina
     * @param id          -id of marina, which one update
     */
    public void updateCollection(SpaceMarine spaceMarine, Long id) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.set(Integer.parseInt(String.valueOf(id)), spaceMarine);
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * Returns size of collection
     *
     * @return size of collection
     */
    public int getSizeCollection() {
        return marineStack.size();
    }

    /**
     * Removes marines, which one greater compare marine
     *
     * @param compareMarine -compare marine
     */
    public void removeGreaterCommand(SpaceMarine compareMarine) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.removeIf(spaceMarine -> spaceMarine.compareTo(compareMarine) > 0);
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * create groups based on id
     */
    public void groupCountingById() {
        Map<Long, Long> groupById = marineStack.stream().collect(
                Collectors.groupingBy(SpaceMarine::getId, Collectors.counting()));
        for (Map.Entry<Long, Long> item : groupById.entrySet()) {
            System.out.println("Айди " + item.getKey() + " содержит  - " + item.getValue() + " элемент");
        }
    }

    /**
     * removes marines which one had same health
     *
     * @param health- health of marine
     */
    public void removeAllByHealth(long health) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.removeIf(marine -> health == marine.getHealth());
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * check marine stack is empty
     *
     * @return boolean result
     */
    public boolean collectionIsEmpty() {
        return marineStack.isEmpty();
    }

    /**
     * generate id automatic
     *
     * @return new id for marine
     */
    public Long generateId() {
        if (!marineStack.empty()) {
            return marineStack.peek().getId() + 1;
        }
        return 0L;
    }

    /**
     * removes marines which one had same achievements
     *
     * @param argument -achievement
     */
    public void removeAnyByAchievements(String argument) {
        tmpMarine.addAll(0, marineStack);
        for (SpaceMarine marine : tmpMarine
        ) {
            if (marine.getAchievements().equals(argument)) {
                tmpMarine.remove(marine);
                break;
            }
        }
        marineStack.clear();
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * removes first element of collection
     */
    public void removeFirst() {
        tmpMarine.addAll(0, marineStack);
        tmpMarine.remove(0);
        marineStack.clear();
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * load collection from file
     */
    public void loadCollectionFromStartFile() {
        marineStack = fileManager.loader();
        initializationDate = LocalDate.now();

    }

    /**
     * return marina, which one had that id
     *
     * @param id- id of find marine
     * @return marine with this id, if didn't find -return null
     */
    public SpaceMarine getById(Long id) {
        for (SpaceMarine marine : marineStack) {
            if (marine.getId().equals(id)) {
                return marine;
            }
        }
        return null;
    }

    /**
     * remove marine from collection
     *
     * @param marine- removed marine
     */
    public void removeFromCollection(SpaceMarine marine) {
        marineStack.remove(marine);
    }

    /**
     * Outputs stack of marines
     *
     * @return stack of marines
     */
    public Stack<SpaceMarine> getMarineStack() {
        return marineStack;
    }

    /**
     * output information about collection
     */
    public void infoCollection() {
        System.out.println("Тип коллекции : " + marineStack.getClass());
        System.out.println("Количество элементов в коллекции : " + marineStack.size());
        System.out.println("Дата создания: " + initializationDate);
        if (!(lastUpdate == null)) {
            System.out.println("Дата последнего обновления : " + lastUpdate);
        } else {
            System.out.println("Дата последнего обновления : ещё не обновлялась");
        }
    }

    /**
     * clear collection
     */
    public void clearCollection() {
        marineStack.clear();
        lastUpdate = LocalDate.now();
    }

    /**
     * show collection
     */
    public void showCollection() {
        try {
            if (marineStack.size() > 0) {
                for (SpaceMarine marines : marineStack) {
                    System.out.println(marines);
                }
            } else {
                System.out.println("Коллекция пуста");
            }
        } catch (EmptyStackException e) {
            System.out.println("Пустая коллекциия, обратитесь к ней после добавления элементов");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
