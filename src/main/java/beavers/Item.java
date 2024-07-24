package beavers;

public class Item {
    String name;
    String description;
    private String type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
        
        
    }

    public String getName() {
        return this.name;
    }

    public String playedWith() {
        if(this.type.equalsIgnoreCase("toy")) {
            return "You played with the " + this.name;
        }else{
            return "You can't play with the " + this.name;
        }
        
    }

}
