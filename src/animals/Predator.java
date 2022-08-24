package animals;

import root.Location;

import java.util.HashMap;

public class Predator extends Animal {

    private final HashMap <AnimalType, Integer> canEat;

    public Predator(String ico, Location location, double weightWolf, AnimalType animalType, int speed, double satiety, int maxCountOnLocation, HashMap <AnimalType,Integer> canEat) {
        super(ico,location,weightWolf,animalType, speed, satiety, maxCountOnLocation);
        this.canEat = canEat;
    }

    @Override
    public void eat() {
        if (getCurrentSatiety() < getFullSatiety()){
            for (Herbivores herbivore : getLocation().getHerbivores()) {
                if (canEat.containsKey(herbivore.getType())){

                }
            }
        }

    }

    public HashMap<AnimalType, Integer> getCanEat() {
        return canEat;
    }
}
