package animals;

import root.Location;

public class Predator extends Animal {

    public Predator(String ico, Location location, double weightWolf, AnimalType animalType, int speed, double satiety, int maxCountOnLocation) {
        super(ico,location,weightWolf,animalType, speed, satiety, maxCountOnLocation);
    }

    @Override
    public void eat() {

    }

}
