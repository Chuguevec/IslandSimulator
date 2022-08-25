package animals;


import root.Location;

public class Herbivores extends Animal {


    protected Herbivores(String ico, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        super(ico,  weight, type, speed, satiety, maxCountOnLocation);
    }

    @Override
    public void eat() {

    }

}
