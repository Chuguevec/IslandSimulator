package animals;

import root.Location;

import java.util.HashMap;

public class Boa extends Predator {
    private static final String ICO = "🐍";
    private static final int weightBoa = 15;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BOA;
    private static final int SPEED = 1;
    private static final double TO_SATIETY = 3;
    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final HashMap <AnimalType, Integer> canEat = new HashMap<>();
static {
    canEat.put(AnimalType.FOX, 15);
    canEat.put(AnimalType.RABBIT, 20);
    canEat.put(AnimalType.MOUSE, 40);
    canEat.put(AnimalType.DUCK, 10);
}

    public Boa() {

        super(ICO,weightBoa, ANIMAL_TYPE, SPEED, TO_SATIETY, MAX_COUNT_ON_LOCATION, canEat);
    }



}
