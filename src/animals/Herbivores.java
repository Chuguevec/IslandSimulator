package animals;


import root.Location;

public class Herbivores extends Animal {


    protected Herbivores(String ico, Location location, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        super(ico, location, weight, type, speed, satiety, maxCountOnLocation);
    }

    @Override
    public void eat() {

    }

}
