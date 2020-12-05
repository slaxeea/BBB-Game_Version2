package ch.bbbaden.games;

import java.util.Random;
import net.slashie.libjcsi.CSIColor;
import static net.slashie.libjcsi.CSIColor.*;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 * author simon kappeler Created At: 02.12.2020
 */
public class Zombie implements GameObject {

    // Game Object stuff
    private int zombieX;
    private int zombieY;
    private boolean isDead = false;
    private CSIColor zombieColour = CSIColor.RUBY;
    private String drawstring = "Z";
    private int aufrufe = 0;

    // Zombie stuff
    private int playerX = 0;
    private int playerY = 0;

    private boolean inRangeXpos = false;
    private boolean inRangeYpos = false;
    private boolean inRangeXneg = false;
    private boolean inRangeYneg = false;

    public Zombie(int medX, int medY) {
        this.zombieX = medX;
        this.zombieY = medY;
    }

    @Override
    public void update(WSwingConsoleInterface csi, Player player) {
        playerX = player.getX();
        playerY = player.getY();

        if (zombieX != playerX && zombieY != playerY) {
            // X coords prüfen
            inRangeXpos = playerX - zombieX > 0 ? true : false;
            inRangeXneg = playerX - zombieX < 0 ? true : false;

            // Y coords prüfen
            inRangeYpos = playerY - zombieY > 0 ? true : false;
            inRangeYneg = playerY - zombieY < 0 ? true : false;

            // System.out.println("playerX: " + playerX + " zombieX: " + zombieX + " \nplayerY: " + playerY + " zombieY: " + zombieY + "\n" + inRange + "\n");
            if (inRangeXpos) {
                zombieX++;
            }
            if (inRangeXneg) {
                zombieX--;
            }
            if (inRangeYpos) {
                zombieY++;
            }
            if (inRangeYneg) {
                zombieY--;
            }
        } else {
            isDead = true;
        }
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
        return zombieX;
    }

    @Override
    public int getY() {
        return zombieY;
    }

    @Override
    public CSIColor getCsiColor() {
        aufrufe++;
        CSIColor[] cols = {
            BLACK,
            BLUE,
            BROWN,
            CYAN,
            DARK_BLUE,
            DARK_GRAY,
            DARK_RED,
            GRAY,
            GREEN,
            LIME,
            LIGHT_GRAY,
            MAGENTA,
            ORANGE,
            PINK,
            PURPLE,
            TEAL,
            RED,
            WHITE,
            YELLOW,
            ALICE_BLUE,
            ALIZARIN,
            AMARANTH,
            AMBER,
            AMETHYST,
            APRICOT,
            AQUA,
            AQUAMARINE,
            ARMY_GREEN,
            ASPARAGUS,
            ATOMIC_TANGERINE,
            AUBURN,
            AZUL,
            AZURE,
            BABY_BLUE,
            BEIGE,
            BISTRE,
            PIGMENT_BLUE,
            BLUE_GREEN,
            BLUE_VIOLET,
            BONDI_BLUE,
            BRASS,
            BRIGHT_GREEN,
            BRIGHT_PINK,
            BRIGHT_TURQUOISE,
            BRILLIANT_ROSE,
            BRONZE,
            BROWNER,
            BUFF,
            BURGUNDY,
            BURNT_ORANGE,
            BURNT_SIENNA,
            BURNT_UMBER,
            CAMO_GREEN,
            CAPUT_MORTUUM,
            CARDINAL,
            CARMINE,
            CARNATION_PINK,
            CAROLINA_BLUE,
            CARROT_ORANGE,
            CELADON,
            CERISE,
            CERULEAN,
            CERULEAN_BLUE,
            CHARTREUSE,
            CHARTREUSE_GREEN,
            CHERRY_BLOSSOM,
            CHESTNUT,
            CHOCOLATE,
            CINNABAR,
            CINNAMON,
            COBALT,
            COLUMBIA_BLUE,
            COPPER,
            COPPER_ROSE,
            CORAL,
            CORAL_RED,
            CORN,
            CORNFLOWER_BLUE,
            COSMIC_LATTE,
            CREAM,
            CRIMSON,
            DARK_BROWN,
            DARK_CERULEAN,
            DARK_CHESTNUT,
            DARK_CORAL,
            DARK_GOLDENROD,
            DARK_GREEN,
            DARK_KHAKI,
            DARK_PASTEL_GREEN,
            DARK_PINK,
            DARK_SCARLET,
            DARK_SALMON,
            DARK_SLATE_GRAY,
            DARK_SPRING_GREEN,
            DARK_TAN,
            DARK_TURQUOISE,
            DARK_VIOLET,
            DEEP_CERISE,
            DEEP_CHESTNUT,
            DEEP_FUCHSIA,
            DEEP_LILAC,
            DEEP_MAGENTA,
            DEEP_PEACH,
            DEEP_PINK,
            DENIM,
            DODGER_BLUE,
            ECRU,
            EGYPTIAN_BLUE,
            ELECTRIC_BLUE,
            ELECTRIC_GREEN,
            ELECTRIC_INDIGO,
            ELECTRIC_LIME,
            ELECTRIC_PURPLE,
            EMERALD,
            EGGPLANT,
            FALU_RED,
            FERN_GREEN,
            FIREBRICK,
            FLAX,
            FOREST_GREEN,
            FRENCH_ROSE,
            FUCSHIA_PINK,
            GAMBOGE,
            GOLD,
            GOLDEN,
            GOLDEN_BROWN,
            GOLDEN_YELLOW,
            GOLDENROD,
            GRAY_ASPARAGUS,
            GREEN_YELLOW,
            HAN_PURPLE,
            HELIOTROPE,
            HOLLYWOOD_CERISE,
            HOT_MAGENTA,
            HOT_PINK,
            INDIGO_DYE,
            INDIGO,
            INTERNATIONAL_KLEIN_BLUE,
            INTERNATIONAL_ORANGE,
            ISLAMIC_GREEN,
            IVORY,
            JADE,
            KELLY_GREEN,
            KHAKI,
            LIGHT_KHAKI,
            LAVENDER_FLORAL,
            LAVENDER,
            LAVENDER_BLUE,
            LAVENDER_BLUSH,
            LAVENDER_GRAY,
            LAVENDER_MAGENTA,
            LAVENDER_PINK,
            LAVENDER_PURPLE,
            LAVENDER_ROSE,
            LAWN_GREEN,
            LEMON_CHIFFON,
            LIGHT_BLUE,
            LIGHT_PINK,
            LILAC,
            LEMON,
            LIGHT_LIME,
            LIME_GREEN,
            LINEN,
            MAGENTA_DYE,
            MAGIC_MINT,
            MAGNOLIA,
            MALACHITE,
            MAROON,
            LIGHT_MAROON,
            MAYA_BLUE,
            MAUVE,
            MAUVE_TAUPE,
            MEDIUM_BLUE,
            MEDIUM_CARMINE,
            MEDIUM_LAVENDER_MAGENTA,
            MEDIUM_PURPLE,
            MEDIUM_SPRING_GREEN,
            MIDNIGHT_BLUE,
            MINT_GREEN,
            MISTY_ROSE,
            MOSS_GREEN,
            MOUNTBATTEN_PINK,
            MUSTARD,
            MYRTLE,
            NAVAJO_WHITE,
            NAVY_BLUE,
            OCHRE,
            OLD_GOLD,
            OLD_LACE,
            OLD_LAVENDER,
            OLD_ROSE,
            OLIVE,
            OLIVE_DRAB,
            OLIVINE,
            ORANGE_PEEL,
            ORANGE_RED,
            ORCHID,
            PALE_BLUE,
            PALE_BROWN,
            PALE_CARMINE,
            PALE_CHESTNUT,
            PALE_CORNFLOWER_BLUE,
            PALE_MAGENTA,
            PALE_PINK,
            PALE_RED_VIOLET,
            PAPAYA_WHIP,
            PASTEL_GREEN,
            PASTEL_PINK,
            PEACH,
            PEACH_ORANGE,
            PEACH_YELLOW,
            PEAR,
            PERIWINKLE,
            PERSIAN_BLUE,
            PERSIAN_GREEN,
            PERSIAN_INDIGO,
            PERSIAN_RED,
            PERSIAN_PINK,
            PERSIAN_ROSE,
            PERSIMMON,
            PINE_GREEN,
            TRUE_PINK,
            PINK_ORANGE,
            PLATINUM,
            PLUM,
            POWDER_BLUE,
            PUCE,
            PRUSSIAN_BLUE,
            PSYCHEDELIC_PURPLE,
            PUMPKIN,
            PURPLE_TAUPE,
            RAW_UMBER,
            RAZZMATAZZ,
            RED_PIGMENT,
            RED_VIOLET,
            RICH_CARMINE,
            ROBIN_EGG_BLUE,
            ROSE,
            ROSE_MADDER,
            ROSE_TAUPE,
            ROYAL_BLUE,
            ROYAL_PURPLE,
            RUBY,
            RUSSET,
            RUST};
        Random rand = new Random();
        int index = rand.nextInt(cols.length);
        index = index < 0 ? index++ : index;
        index = index > cols.length ? index-- : index;
        zombieColour = cols[index];
        return zombieColour;
    }
}
