package ch.bbbaden.games;

import java.util.List;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * author simon kappeler Created At: 02.12.2020
 */
public class Player implements GameObject {

    // Variables for all Game Objects
    private int playerX;
    private int playerY;
    private boolean isDead = false;
    private CSIColor playerColour = CSIColor.ATOMIC_TANGERINE;
    private String drawstring = "P";

    // Variables for Player
    private int health = 100;
    private int points = 0;

    private int playerNextX = 0;
    private int playerNextY = 0;

    // Constructor
    public Player(int playerX, int playerY) {
        this.playerX = playerX;
        this.playerY = playerY;
    }

    public void action(int keychar, WSwingConsoleInterface csi) {
        switch (keychar) {
            case CharKey.UARROW:
                playerNextY = playerY - 1;
                break;
            case CharKey.DARROW:
                playerNextY = playerY + 1;
                break;
            case CharKey.LARROW:
                playerNextX = playerX - 1;
                break;
            case CharKey.RARROW:
                playerNextX = playerX + 1;
                break;
            case CharKey.Q:
            case CharKey.q:
                System.exit(0);
                break;
        }

        // Check X boundrys
        playerNextX = playerNextX > 77 ? 0 : playerNextX;
        playerNextX = playerNextX < 0 ? 78 : playerNextX;

        // Check Y boundrys
        playerNextY = playerNextY > 23 ? 0 : playerNextY;
        playerNextY = playerNextY < 0 ? 23 : playerNextY;

        // Check for obstacles X and Y
        boolean istrap = csi.peekChar(playerNextX, playerNextY) == 'X' ? true : false;
        if (csi.peekChar(playerNextX, playerNextY) != ' ' && !istrap) {
            playerNextX = playerX;
            playerNextY = playerY;
        }

        playerX = playerNextX;
        playerY = playerNextY;
    }

    public void update(WSwingConsoleInterface csi, Player player, List<GameObject> gm) {
        points++;

        // Look for Zombies
        Zombie z = new Zombie(111, 111);
        for (GameObject gam : gm) {

            if (z.getClass() == gam.getClass()) {
                if (gam.getX() == playerX || gam.getY() == playerY) {
                    health--;
                }
            }
        }

        // Look for Traps
        Medkit m = new Medkit(111, 111);
        for (GameObject gam : gm) {

            if (m.getClass() == gam.getClass()) {
                if (gam.getX() == playerX || gam.getY() == playerY) {
                    health -= 10;
                }
            }
        }
    }

    // Health and Point get- / setters
    public int getHealth() {
        return health;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints() {
        points++;
    }

    // Implementation of the Interface
    @Override
    public void update(WSwingConsoleInterface csi, Player player) {

    }

    @Override
    public String getDrawString() {
        return drawstring;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    @Override
    public int getX() {
        return playerX;
    }

    @Override
    public int getY() {
        return playerY;
    }

    @Override
    public CSIColor getCsiColor() {
        return playerColour;
    }

}
