package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * author simon kappeler Created At: 02.12.2020
 */
public class Medkit implements GameObject {

    private int medX;
    private int medY;
    private boolean isDead = false;
    private CSIColor medColour = CSIColor.DARK_PINK;
    private String drawstring = "M";

    public Medkit(int medX, int medY) {
        this.medX = medX;
        this.medY = medY;
    }

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
        return medX;
    }

    @Override
    public int getY() {
        return medY;
    }

    @Override
    public CSIColor getCsiColor() {
        return medColour;
    }
}
