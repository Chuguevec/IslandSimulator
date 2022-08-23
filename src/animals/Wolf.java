package animals;

import root.Location;

public class Wolf extends Predator {
    public static final String ICO = "🐺";
    public static final double WEIGHT_WOLF = 50;
    public static final int SPEED = 3;
    public static final double TO_SATIETY = 8;
    private static final AnimalType ANIMAL_TYPE = AnimalType.WOLF;
    private static final int MAX_COUNT_ON_LOCATION = 30;

    public Wolf(Location location) {
        super(ICO, location, WEIGHT_WOLF, ANIMAL_TYPE, SPEED, TO_SATIETY, MAX_COUNT_ON_LOCATION);

    }


}

