package animals;

import java.util.HashMap;

public interface EatAnimal {

    default void eatAnimal(HashMap<AnimalType, Integer> canEat){
        System.out.println();
    }
}
