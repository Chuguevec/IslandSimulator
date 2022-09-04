package main;
import animals.*;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Island {
    public Location[][] locations;
    private static volatile int predatorCount;
    private static final Object monitor = new Object();
    private static final HashMap<AnimalType, Integer> startAnimals = new HashMap<>();

    static {
        startAnimals.put(AnimalType.WOLF, OptionIsland.wolf);
        startAnimals.put(AnimalType.BOA, OptionIsland.boa);
        startAnimals.put(AnimalType.FOX, OptionIsland.fox);
        startAnimals.put(AnimalType.BEAR, OptionIsland.bear);
        startAnimals.put(AnimalType.EAGLE, OptionIsland.eagle);
        startAnimals.put(AnimalType.HORSE, OptionIsland.horse);
        startAnimals.put(AnimalType.DEER, OptionIsland.deer);
        startAnimals.put(AnimalType.RABBIT, OptionIsland.rabbit);
        startAnimals.put(AnimalType.MOUSE, OptionIsland.mouse);
        startAnimals.put(AnimalType.GOAT, OptionIsland.goat);
        startAnimals.put(AnimalType.SHEEP, OptionIsland.sheep);
        startAnimals.put(AnimalType.BOAR, OptionIsland.boar);
        startAnimals.put(AnimalType.BUFFALO, OptionIsland.buffalo);
        startAnimals.put(AnimalType.DUCK, OptionIsland.duck);
        startAnimals.put(AnimalType.CATERPILLAR, OptionIsland.caterpillar);
    }


    public Island() {
        locations = new Location[OptionIsland.HEIGHT_ISLAND][OptionIsland.WIDTH_ISLAND];
        initialize();
    }

    public static void incrementPredatorCount() {
        synchronized (monitor){
            predatorCount++;
        }

    }

    public static void decrementPredatorCount() {
        synchronized (monitor){
            predatorCount--;
        }

    }

    public static int getPredatorCount() {
        return predatorCount;
    }

    private void initialize() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
        addStartAnimals();
    }

    public void printLocations() {
        for (Location[] location : locations) {
            for (Location value : location) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    private void addStartAnimals() {
        startAnimals.forEach((animalType, integer) -> {
            while (integer > 0) {
                Location location = randomLocation();
                Animal animal = AnimalFactory.createAnimal(animalType);
                location.addAnimal(animal);
                System.out.println("В локацию " + location.getLocationCount() + " добавлено животное: " + animalType + " " + animal);
                integer--;
            }
        });
    }

    public Location randomLocation() {
        int randomX = ThreadLocalRandom.current().nextInt(OptionIsland.HEIGHT_ISLAND);
        int randomY = ThreadLocalRandom.current().nextInt(OptionIsland.WIDTH_ISLAND);
        return locations[randomX][randomY];
    }
}

