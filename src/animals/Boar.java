package animals;

public class Boar extends Herbivores{
    private static final String ICO = "\uD83D\uDC17";
    public static final double WEIGHT = 400;
    public static final int SPEED = 2;
    public static final double FULL_SATIETY = 50;
    private static final AnimalType ANIMAL_TYPE = AnimalType.BOAR;
    private static final int MAX_COUNT_ON_LOCATION = 50;

    public Boar () {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }
}
