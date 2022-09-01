package animals;

import java.util.HashMap;

public class Bear extends Predator{
    public static final String ICO = "\uD83D\uDC3B";
    public static final double WEIGHT = 500;
    public static final int SPEED = 2;
    public static final double FULL_SATIETY = 80;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BEAR;
    private static final int MAX_COUNT_ON_LOCATION = 5;
    private static final HashMap <AnimalType, Integer> CAN_EAT =new HashMap<>();

    static {
        CAN_EAT.put(AnimalType.BOA, 80);
        CAN_EAT.put(AnimalType.HORSE, 40);
        CAN_EAT.put(AnimalType.DEER,80);
        CAN_EAT.put(AnimalType.RABBIT, 80);
        CAN_EAT.put(AnimalType.MOUSE, 90);
        CAN_EAT.put(AnimalType.GOAT, 70);
        CAN_EAT.put(AnimalType.SHEEP, 70);
        CAN_EAT.put(AnimalType.BOAR, 50);
        CAN_EAT.put(AnimalType.BUFFALO, 20);
        CAN_EAT.put(AnimalType.DUCK, 10);
    }
    public Bear() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY , MAX_COUNT_ON_LOCATION, CAN_EAT);
    }
}
