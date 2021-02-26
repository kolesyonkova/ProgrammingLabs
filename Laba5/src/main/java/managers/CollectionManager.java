package managers;

import data.SpaceMarine;

import java.util.Stack;

public class CollectionManager {
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
//    public Long getHealth(){
//        Long health = 1L;
//        if(!marineStack.empty()){
//        for (SpaceMarine marines : marineStack) {
//            health=health+marines.getHealth();
//        }}
//        return health;

    //}
    public void showCollection() {
        for (SpaceMarine marines : marineStack) {
            System.out.println(marines);
        }
    }
}
