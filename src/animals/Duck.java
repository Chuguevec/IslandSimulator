package animals;

import java.util.HashMap;

public class Duck extends Herbivores implements EatAnimal{
    private static final String ICO = "\uD83D\uDC03";
    public static final double WEIGHT = 1;
    private static final int MAX_COUNT_ON_LOCATION = 200;
    public static final int SPEED = 4;
    public static final double FULL_SATIETY = 0.15;
    private static final AnimalType ANIMAL_TYPE = AnimalType.DUCK;
    private static final HashMap<AnimalType, Integer> canEat = new HashMap<>();

    {
        canEat.put(AnimalType.CATERPILLAR,90);
    }

    public Duck () {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }

    @Override
    public void eat() {
        super.eat();
        if (getCurrentSatiety() < getFullSatiety()){
            eatAnimal(this, canEat);
        }
    }
}
