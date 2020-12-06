package Moves;

public interface MovesInHome {
    void say();

    default String sayanythink(String a){
        return a;
    };

    ;
    void turnChair(String name,boolean isRandom, int count);
    void turnChair(String name,boolean isRandom, int count,int count2);

    void push(String thrown, boolean isAggressive);
}
