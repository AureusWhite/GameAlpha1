package jackal.face;

public class NPC {
    private String name;
    private String description;
    private String type;

    public NPC(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;

    }
    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
        this.type = "friendly";
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String interact() {
        if (this.type.equalsIgnoreCase("friendly")) {
            return "You talked to " + this.name;
        } else {
            return "You can't talk to " + this.name;
        }
    }
    public void dialog(Player player) {
    }
    
}