package managers;

import data.SpaceMarine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class CollectionManager {
    private LocalDate initializationDate;
    private LocalDate lastUpdate;
    private Stack<SpaceMarine> marineStack = new Stack<>();
    private ArrayList<SpaceMarine> tmpMarine=new ArrayList<>();
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void addToCollection(SpaceMarine spaceMarine) {
        marineStack.push(spaceMarine);
        lastUpdate = LocalDate.now();
    }
    public void updateCollection(SpaceMarine spaceMarine,Long id){
            tmpMarine.addAll(0, marineStack);
            marineStack.clear();
            tmpMarine.set(Integer.parseInt(String.valueOf(id)),spaceMarine);
            marineStack.addAll(0,tmpMarine);
            tmpMarine.clear();
    }
    public int getSizeCollection(){
        return marineStack.size();
    }
    public boolean collectionIsEmpty(){
        return marineStack.isEmpty();
    }
    public Long generateId() {
        if (!marineStack.empty()) {
            return marineStack.peek().getId() + 1;
        }
        return 0L;
    }

    public void loadCollectionFromStartFile() {
        marineStack = fileManager.loader();
        initializationDate = LocalDate.now();

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
    public void clearCollection(){
        for (int i = 0; i <= marineStack.size()+1; i++) {
            marineStack.pop();
        }
        lastUpdate=LocalDate.now();
    }
    public void showCollection() {
        try {
            if(marineStack.size()>0){
            for (SpaceMarine marines : marineStack) {
                System.out.println(marines);
            }}else {
                System.out.println("Коллекция пуста");
            }
        } catch (EmptyStackException e) {
            System.out.println("Пустая коллекциия, обратитесь к ней после добавления элементов");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так. Повторите ввод.");
        }
    }
}
