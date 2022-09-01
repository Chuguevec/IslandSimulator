package animals;

public class Deer extends Herbivores {
    private static final String ICO = "\uD83E\uDD8C";
    public static final double WEIGHT = 300;
    public static final int SPEED = 4;
    public static final double FULL_SATIETY = 50;
    private static final AnimalType ANIMAL_TYPE = AnimalType.DEER;
    private static final int MAX_COUNT_ON_LOCATION = 20;

    public Deer() {
        super(ICO, WEIGHT, ANIMAL_TYPE, SPEED, FULL_SATIETY, MAX_COUNT_ON_LOCATION);
    }
}
