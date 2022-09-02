package animals;

import java.util.HashMap;

public class Mouse extends Herbivores implements EatAnimal {
    private static final String ICO = "\uD83D\uDC01";
    public static final double WEIGHT = 0.05;
    public static final int SPEED = 1;
    public static final double FULL_SATIETY = 0.01;
    private static final AnimalType ANIMAL_TYPE = AnimalType.MOUSE;
    private static final int MAX_COUNT_ON_LOCATION = 500;
    private static final HashMap <AnimalType, Integer> canEat = new HashMap<>();

    static {
        canEat.put(AnimalType.CATERPILLAR, 90);
    }

    public Mouse() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }

    @Override
    public void eat() {
        super.eat();
        if (isHungry()){
          eatAnimal(this, canEat);
        }
    }
}
