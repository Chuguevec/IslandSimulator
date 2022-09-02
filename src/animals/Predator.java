package animals;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    private final HashMap <AnimalType, Integer> canEat;

    public Predator(String ico, double weight, AnimalType animalType, int speed, double satiety, int maxCountOnLocation, HashMap <AnimalType,Integer> canEat) {
        super(ico,weight,animalType, speed, satiety, maxCountOnLocation);
        this.canEat = canEat;
    }

    @Override
    public void eat() {
        if (isHungry()){
            for (Animal animal : getLocation().getAnimals()) {
                if (canEat.containsKey(animal.getType())){
                    int random = ThreadLocalRandom.current().nextInt(100);
                    int percentEat = canEat.get(animal.getType());
                    if (random <= percentEat){
                        this.setCurrentSatiety(Math.min(getCurrentSatiety() + animal.getWeight(), getFullSatiety()));
                        this.getLocation().removeAnimal(animal);
                        if (!isHungry()) break;
                    }
                }
            }
        }

    }

    public HashMap<AnimalType, Integer> getCanEat() {
        return canEat;
    }
}
