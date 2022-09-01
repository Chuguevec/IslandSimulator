package animals;

public class AnimalFactory {
    public static Animal createAnimal (AnimalType type){
        Animal animal = null;

        switch (type) {
            case WOLF -> animal = new Wolf();
            case BOA -> animal = new Boa();
            case RABBIT -> animal = new Rabbit();
            case BEAR -> animal = new Bear();
            case BUFFALO -> animal = new Buffalo();
            case CATERPILLAR -> animal = new Caterpillar();
            case FOX -> animal = new Fox();
            case BOAR -> animal = new Boar();
            case DEER -> animal = new Deer();
            case DUCK -> animal = new Duck();
            case GOAT -> animal = new Goat();
            case EAGLE -> animal = new Eagle();
            case HORSE -> animal = new Horse();
            case MOUSE -> animal = new Mouse();
            case SHEEP -> animal = new Sheep();
        }

        return animal;
    }
}
