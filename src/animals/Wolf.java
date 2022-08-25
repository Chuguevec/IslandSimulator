package animals;

import root.Location;

import java.util.HashMap;

public class Wolf extends Predator {
    public static final String ICO = "🐺";
    public static final double WEIGHT_WOLF = 50;
    public static final int SPEED = 3;
    public static final double TO_SATIETY = 8;
    private static final AnimalType ANIMAL_TYPE = AnimalType.WOLF;
    private static final int MAX_COUNT_ON_LOCATION = 30;
    private static final HashMap <AnimalType, Integer> canEat =new HashMap<>();

    static {
        canEat.put(AnimalType.HORSE, 10);
        canEat.put(AnimalType.DEER,15 );
        canEat.put(AnimalType.RABBIT, 60);
        canEat.put(AnimalType.MOUSE, 80);
        canEat.put(AnimalType.GOAT, 60);
        canEat.put(AnimalType.SHEEP, 70);
        canEat.put(AnimalType.BOAR, 15);
        canEat.put(AnimalType.BUFFALO, 10);
        canEat.put(AnimalType.DUCK, 40);
    }


    public Wolf() {
        super(ICO, WEIGHT_WOLF, ANIMAL_TYPE, SPEED, TO_SATIETY, MAX_COUNT_ON_LOCATION, canEat);

    }


}

