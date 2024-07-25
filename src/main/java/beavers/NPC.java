package beavers;

public class NPC {

    private String name;
    private String disc;

    public NPC(String name, String disc) {
        this.name = name;
        this.disc = disc;
    }
    
    public String getName() {
        return name;
    }
     
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDisc() {
        return disc;
    }
    
    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getDialogue() {
        return "Hello, I am " + name + ". " + disc;
    }
}
