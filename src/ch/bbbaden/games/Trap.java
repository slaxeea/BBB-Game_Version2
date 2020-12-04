package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * author simon kappeler Created At: 02.12.2020
 */
public class Trap implements GameObject {

    private int trapX;
    private int trapY;
    private boolean isDead = false;
    private CSIColor trapColour = CSIColor.LIME;
    private String drawstring = "X";

    public Trap(int trapX, int trapY) {
        this.trapX = trapX;
        this.trapY = trapY;
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
        return trapX;
    }

    @Override
    public int getY() {
        return trapY;
    }

    @Override
    public CSIColor getCsiColor() {
        return trapColour;
    }
}
