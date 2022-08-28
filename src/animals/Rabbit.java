package animals;

public class Rabbit extends Herbivores{
    private static final String ICO = "🐇";
    public static final double WEIGHT = 2;
    public static final int SPEED = 2;
    public static final double TO_SATIETY = 0.45;
    private static final AnimalType ANIMAL_TYPE = AnimalType.RABBIT;
    private static final int MAX_COUNT_ON_LOCATION = 150;


    public Rabbit() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, TO_SATIETY, MAX_COUNT_ON_LOCATION);
    }

}
