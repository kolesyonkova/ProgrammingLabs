package managers;

import data.SpaceMarine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class CollectionManager {
    private LocalDate initializationDate;
    private LocalDate lastUpdate;
    private Stack<SpaceMarine> marineStack = new Stack<>();
    private ArrayList<SpaceMarine> tmpMarine = new ArrayList<>();
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void addToCollection(SpaceMarine spaceMarine) {
        marineStack.push(spaceMarine);
        lastUpdate = LocalDate.now();
    }

    public void updateCollection(SpaceMarine spaceMarine, Long id) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.set(Integer.parseInt(String.valueOf(id)), spaceMarine);
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    public int getSizeCollection() {
        return marineStack.size();
    }

    public void removeGreaterCommand(SpaceMarine compareMarine) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.removeIf(spaceMarine -> spaceMarine.compareTo(compareMarine) > 0);
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    public void groupCountingById() {
        Map<Long, Long> groupById = marineStack.stream().collect(
                Collectors.groupingBy(SpaceMarine::getId, Collectors.counting()));
        for (Map.Entry<Long, Long> item : groupById.entrySet()) {
            System.out.println("Айди " + item.getKey() + " содержит  - " + item.getValue() + " элемент");
        }
    }

    public void removeAllByHealth(long health) {
        tmpMarine.addAll(0, marineStack);
        marineStack.clear();
        tmpMarine.removeIf(marine -> health == marine.getHealth());
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    public boolean collectionIsEmpty() {
        return marineStack.isEmpty();
    }

    public Long generateId() {
        if (!marineStack.empty()) {
            return marineStack.peek().getId() + 1;
        }
        return 0L;
    }

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

    public void removeFirst() {
        tmpMarine.addAll(0, marineStack);
        tmpMarine.remove(0);
        marineStack.clear();
        marineStack.addAll(0, tmpMarine);
        tmpMarine.clear();
        lastUpdate = LocalDate.now();
    }

    public void loadCollectionFromStartFile() {
        marineStack = fileManager.loader();
        initializationDate = LocalDate.now();

    }

    public SpaceMarine getById(Long id) {
        for (SpaceMarine marine : marineStack) {
            if (marine.getId().equals(id)) {
                return marine;
            }
        }
        return null;
    }

    public void removeFromCollection(SpaceMarine marine) {
        marineStack.remove(marine);
    }

    public Stack<SpaceMarine> getMarineStack() {
        return marineStack;
    }

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

    public void clearCollection() {
        for (int i = 0; i <= marineStack.size() + 1; i++) {
            marineStack.pop();
        }
        lastUpdate = LocalDate.now();
    }

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
