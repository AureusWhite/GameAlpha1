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
    public void dialogue(Player player) {
        switch(player.getPerk()){
            case "friendly" -> System.out.println("Hello, "+player.getName()+"! How are you today?");
            case "rude" -> System.out.println("What do you want?");
            case "neutral" -> System.out.println("Hello, "+player.getName()+".");

        }

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

}
