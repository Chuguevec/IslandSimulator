package animals;

import java.util.HashMap;

public class Boa extends Predator {
    private static final String ICO = "🐍";
    private static final int weightBoa = 15;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BOA;
    private static final int SPEED = 1;
    private static final double FULL_SATIETY = 3;
    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final HashMap <AnimalType, Integer> CAN_EAT = new HashMap<>();

static {
    CAN_EAT.put(AnimalType.FOX, 15);
    CAN_EAT.put(AnimalType.RABBIT, 20);
    CAN_EAT.put(AnimalType.MOUSE, 40);
    CAN_EAT.put(AnimalType.DUCK, 10);
}

    public Boa() {

        super(ICO,weightBoa, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION, CAN_EAT);
    }



}
