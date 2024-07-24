package beavers;

public interface Perk {
    String name = "Default";
    String description = "Default";
    default String getName(){
        return this.getName();

    }
}
