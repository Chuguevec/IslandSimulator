package animals;

import java.util.HashMap;

public interface EatAnimal {

    default void eatAnimal(Animal predator, HashMap <AnimalType, Integer> canEat){
        if (predator.getCurrentSatiety() < predator.getFullSatiety()){
            for (Animal animal : predator.getLocation().getAnimals()) {
                if (canEat.containsKey(animal.getType())){
                    int random = (int) (Math.random()*100);
                    int percentEat = canEat.get(animal.getType());
                    if (random <= percentEat){
                        predator.setCurrentSatiety( predator.getCurrentSatiety() + animal.getWeight());
                        predator.getLocation().removeAnimal(animal);
                        if (predator.getCurrentSatiety() < predator.getFullSatiety()) break;
                    }
                }
            }
        }
    }
}
