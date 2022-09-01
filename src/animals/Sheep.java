package animals;

public class Sheep extends Herbivores{
    private static final String ICO = "\uD83D\uDC11";
    public static final double WEIGHT = 70;
    public static final int SPEED = 3;
    public static final double FULL_SATIETY = 15;
    private static final AnimalType ANIMAL_TYPE = AnimalType.SHEEP;
    private static final int MAX_COUNT_ON_LOCATION = 140;


    public Sheep() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }

}
