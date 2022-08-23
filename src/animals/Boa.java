package animals;

import root.Location;

public class Boa extends Predator {
    private static final String ICO = "🐍";
    private static final int weightBoa = 15;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BOA;
    private static final int SPEED = 1;
    private static final double TO_SATIETY = 3;
    private static final int MAX_COUNT_ON_LOCATION = 30;

    public Boa(Location location) {

        super(ICO, location,weightBoa, ANIMAL_TYPE, SPEED, TO_SATIETY, MAX_COUNT_ON_LOCATION);
    }



}
