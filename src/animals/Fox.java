package animals;

import java.util.HashMap;

public class Fox extends Predator {
    public static final String ICO = "\uD83E\uDD8A";
    public static final double WEIGHT = 8;
    public static final int SPEED = 2;
    public static final double FULL_SATIETY = 8;
    private static final AnimalType ANIMAL_TYPE = AnimalType.FOX;
    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final HashMap <AnimalType, Integer> CAN_EAT =new HashMap<>();

    static {
        CAN_EAT.put(AnimalType.RABBIT, 70);
        CAN_EAT.put(AnimalType.MOUSE, 90);
        CAN_EAT.put(AnimalType.DUCK, 60);
        CAN_EAT.put(AnimalType.CATERPILLAR, 40);

    }

    public Fox() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION, CAN_EAT);
    }
}
