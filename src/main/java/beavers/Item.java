package beavers;

public class Item {
    String name;
    String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        
    }

    public String getName() {
        return this.name;
    }

}
