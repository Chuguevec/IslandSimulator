package animals;

import root.Location;

public class AnimalFactory {
    public static Animal createAnimal (AnimalType type, Location location){
        Animal animal = null;

        switch (type) {
            case WOLF -> animal = new Wolf(location);
            case BOA -> animal = new Boa(location);

        }

        return animal;
    }
}
