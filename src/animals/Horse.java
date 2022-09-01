package animals;

import javax.swing.plaf.metal.MetalBorders;

public class Horse extends Herbivores {
    private static final String ICO = "\uD83D\uDC0E";
    public static final double WEIGHT = 400;
    public static final int SPEED = 4;
    public static final double FULL_SATIETY = 60;
    private static final AnimalType ANIMAL_TYPE = AnimalType.HORSE;
    private static final int MAX_COUNT_ON_LOCATION = 20;

    public Horse() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }
}
