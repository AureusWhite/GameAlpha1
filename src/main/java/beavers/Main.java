package beavers;

import javax.swing.SwingUtilities;

public class Main {
        public static void main(String[] args) {
            Player player = new Player();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Game(player);
                }
            });


    }
}