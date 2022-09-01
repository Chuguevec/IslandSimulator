package animals;

import java.util.HashMap;

public class Wolf extends Predator {
    public static final String ICO = "🐺";
    public static final double WEIGHT = 50;
    public static final int SPEED = 3;
    public static final double FULL_SATIETY = 8;
    private static final AnimalType ANIMAL_TYPE = AnimalType.WOLF;
    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final HashMap <AnimalType, Integer> CAN_EAT =new HashMap<>();

    static {
        CAN_EAT.put(AnimalType.HORSE, 10);
        CAN_EAT.put(AnimalType.DEER,15 );
        CAN_EAT.put(AnimalType.RABBIT, 60);
        CAN_EAT.put(AnimalType.MOUSE, 80);
        CAN_EAT.put(AnimalType.GOAT, 60);
        CAN_EAT.put(AnimalType.SHEEP, 70);
        CAN_EAT.put(AnimalType.BOAR, 15);
        CAN_EAT.put(AnimalType.BUFFALO, 10);
        CAN_EAT.put(AnimalType.DUCK, 40);
    }


    public Wolf() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION, CAN_EAT);

    }


}

