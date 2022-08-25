package animals;

import root.Location;

public class AnimalFactory {
    public static Animal createAnimal (AnimalType type){
        Animal animal = null;

        switch (type) {
            case WOLF -> animal = new Wolf();
            case BOA -> animal = new Boa();
            case RABBIT -> animal = new Rabbit();
        }

        return animal;
    }
}
