package animals;

public class Buffalo extends Herbivores{
    private static final String ICO = "\uD83D\uDC03";
    public static final double WEIGHT = 700;
    private static final int MAX_COUNT_ON_LOCATION = 10;
    public static final int SPEED = 3;
    public static final double FULL_SATIETY = 100;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BUFFALO;


    public Buffalo () {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }
}
