package Objects;

import Persons.Person;

public class Cafeteriy{
    public static Cup createCup(Person p){
        System.out.println("Создал кружку+"+p.getName());
        return new Cup();
    }
}
