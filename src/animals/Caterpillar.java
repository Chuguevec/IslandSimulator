package animals;

public class Caterpillar extends Herbivores {
    private static final String ICO = "\uD83D\uDC1B";
    public static final double WEIGHT = 0.01;
    private static final int MAX_COUNT_ON_LOCATION = 1000;
    public static final int SPEED = 0;
    public static final double FULL_SATIETY = 0;
    private static final AnimalType ANIMAL_TYPE = AnimalType.CATERPILLAR;


    public Caterpillar () {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }

    @Override
    public void newDay() {
    }
}
