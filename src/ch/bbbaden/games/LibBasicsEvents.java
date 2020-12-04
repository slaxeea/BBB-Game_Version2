package ch.bbbaden.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

public class LibBasicsEvents {

    private final WSwingConsoleInterface csi;
    Random rnd = new Random();
    private List<GameObject> gameObjects = new ArrayList<>();

    public LibBasicsEvents() {
        csi = new WSwingConsoleInterface("Basic Game - Event Based");
    }

    public void run() {

        // Draw static part
        setupGameBoard();
        setupGameObjects();

        while (true) {
            csi.restore();

            for (GameObject gm : gameObjects) {
                // System.out.println(gm.getClass() + " " + String.valueOf(gameObjects.indexOf(gm)));
                if (!gm.isDead()) {
                    gm.update(csi, (Player) gameObjects.get(0));
                    csi.print(gm.getX(), gm.getY(), gm.getDrawString(), gm.getCsiColor());
                }
            }

            // New Spawns
            for (int i = 0; i < rnd.nextInt(2); i++) {
                gameObjects.add(new Zombie(i + rnd.nextInt(79), i + rnd.nextInt(24)));
            }

            // Wait for key Input
            int key = csi.inkey().code;
            Player player = (Player) gameObjects.get(0);
            player.action(key, csi);
            gameObjects.set(0, player);

            // Player update
            player.update(csi, player, gameObjects);

            // Dispay health and points
            /*Doesent work because im so FUCKING STUPID
            csi.print(1, 1, String.valueOf(player.getPoints()));
            csi.print(20, 5, String.valueOf(player.getHealth()));
             */
            System.out.println(String.valueOf(player.getHealth()) + "\n");

            csi.refresh();
        }
    }

    private void setupGameBoard() {
        csi.cls();
        csi.saveBuffer();
    }

    private void setupGameObjects() {

        // Add Player
        Player player = new Player(rnd.nextInt(50), rnd.nextInt(20));
        System.out.println("x: " + player.getX() + "  y: " + player.getY());
        gameObjects.add(player);
        // Add Traps
        for (int i = 0; i < rnd.nextInt(2) + 1; i++) {
            gameObjects.add(new Trap(i + rnd.nextInt(79), i + rnd.nextInt(14)));
        }
        // Add Medkits
        for (int i = 0; i < rnd.nextInt(3) + 1; i++) {
            gameObjects.add(new Medkit(i + rnd.nextInt(79), i + rnd.nextInt(24)));
        }
        // Add Zombies
        for (int i = 0; i < rnd.nextInt(3) + 1; i++) {
            gameObjects.add(new Zombie(i + rnd.nextInt(79), i + rnd.nextInt(24)));
        }
        gameObjects.add(new Zombie(1 + rnd.nextInt(70), 2 + rnd.nextInt(20)));

        // Print all Game Objects
        // Not used rn but i might later idk
        /*
        for (GameObject gm : gameObjects) {
            System.out.println(gm.getX() + " " + gm.getY());
            csi.print(gm.getX(), gm.getY(), gm.getDrawString(), gm.getCsiColor());

        }
         */
    }
}
