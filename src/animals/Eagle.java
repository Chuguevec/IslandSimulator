package animals;

import java.util.HashMap;

public class Eagle extends Predator{
    public static final String ICO = "\uD83E\uDD85";
    public static final double WEIGHT = 6;
    public static final int SPEED = 3;
    public static final double FULL_SATIETY = 1;
    private static final AnimalType ANIMAL_TYPE = AnimalType.EAGLE;
    private static final int MAX_COUNT_ON_LOCATION = 20;
    private static final HashMap <AnimalType, Integer> CAN_EAT =new HashMap<>();

    static {
        CAN_EAT.put(AnimalType.FOX, 10);
        CAN_EAT.put(AnimalType.RABBIT, 90);
        CAN_EAT.put(AnimalType.MOUSE, 90);
        CAN_EAT.put(AnimalType.DUCK, 80);
    }
    public Eagle() {
        super(ICO, WEIGHT,ANIMAL_TYPE,SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION, CAN_EAT);
    }
}
