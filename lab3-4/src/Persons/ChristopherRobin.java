package Persons;

public class ChristopherRobin extends Person {
    public ChristopherRobin(String name) {
        super(name);
    }
    public void look(){
        class Dinner{
            private boolean isDinner=true;
            public void setDinner(){
                isDinner=true;
            }
            public void overDinner(){
                isDinner=false;
            }
        }
        Dinner dinner=new Dinner();
        dinner.overDinner();
        Door door=new Door();
        if (door.getCondition()){
            door.openDoor();
        }else {
            door.closeDoor();
        }
        System.out.println("Обед как раз подходил к концу, когда Кристофер Робин заглянул в дверь.");

    }

    public static class Door{
        private boolean isClosed=true;
        public void closeDoor(){
            isClosed=true;
        }
        public void openDoor(){
            isClosed=false;
        }
        public boolean getCondition(){
            return isClosed;
        }
    }

}
