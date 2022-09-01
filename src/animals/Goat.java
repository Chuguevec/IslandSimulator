package animals;

public class Goat extends Herbivores{
    private static final String ICO = "\uD83D\uDC10";
    public static final double WEIGHT = 600;
    public static final int SPEED = 3;
    public static final double FULL_SATIETY = 10;
    private static final AnimalType ANIMAL_TYPE = AnimalType.GOAT;
    private static final int MAX_COUNT_ON_LOCATION = 140;

    public Goat () {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }

}
