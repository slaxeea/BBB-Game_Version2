package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * author simon kappeler Created At: 02.12.2020
 */
public interface GameObject {

    public void update(WSwingConsoleInterface csi, Player player);

    public String getDrawString();

    public boolean isDead();

    public int getX();

    public int getY();

    public CSIColor getCsiColor();

}
