package beavers;


public class Main {

    @SuppressWarnings("unused")
    private static Room room;
    @SuppressWarnings("unused")
    private static NPC npc;

    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);
        game.start();

    }
}