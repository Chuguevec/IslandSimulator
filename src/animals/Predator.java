package animals;

import java.util.HashMap;

public class Predator extends Animal {

    private final HashMap <AnimalType, Integer> canEat;

    public Predator(String ico, double weightWolf, AnimalType animalType, int speed, double satiety, int maxCountOnLocation, HashMap <AnimalType,Integer> canEat) {
        super(ico,weightWolf,animalType, speed, satiety, maxCountOnLocation);
        this.canEat = canEat;
    }

    @Override
    public void eat() {
        if (getCurrentSatiety() < getFullSatiety()){
            for (Animal animal : getLocation().getAnimals()) {
                if (canEat.containsKey(animal.getType())){
                    int random = (int) (Math.random()*100);
                    int percentEat = canEat.get(animal.getType());
                    if (random <= percentEat){
                        this.setCurrentSatiety( getCurrentSatiety() + animal.getWeight());
                        this.getLocation().removeAnimal(animal);
                        if (getCurrentSatiety() < getFullSatiety()) break;
                    }
                }
            }
        }

    }

    public HashMap<AnimalType, Integer> getCanEat() {
        return canEat;
    }
}
