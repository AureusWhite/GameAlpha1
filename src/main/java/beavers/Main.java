package beavers;


public class Main {

    private static Room room;
    private static NPC npc;

    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);
        game.start();

    }
}