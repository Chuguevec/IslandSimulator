package animals;

import main.Island;
import main.Location;
import main.OptionIsland;
import main.Statistics;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    private final String ICO;
    private final double weight;
    private final int speed;
    private final AnimalType type;
    private final int maxCountOnLocation;
    private Location location;
    private final double fullSatiety;
    private double currentSatiety;
    private final double hunger; // Голод. На эту единицу будет уменьшаться насыщение (satiety)


    protected Animal(String ico, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        ICO = ico;
        this.weight = weight;
        this.type = type;
        this.speed = speed;
        fullSatiety = satiety;
        hunger = satiety / 8;
        currentSatiety = (satiety / 100) * OptionIsland.SATIETY_ANIMAL_START;
        this.maxCountOnLocation = maxCountOnLocation;
    }

    public abstract void eat();

    public void move(Location[][] locations) {
        int x = location.getPositionX();
        int y = location.getPositionY();
        int random = ThreadLocalRandom.current().nextInt(4);
        if (random == 0) { //двигаемся влево
            y = Math.max(y - this.speed, 0);
            if (this.location.getLocationCount() == locations[x][y].getLocationCount()) {
                y = Math.min(y + this.speed, locations[x].length - 1);
            }
        }
        if (random == 1) { //двигаемся вправо
            y = Math.min(y + this.speed, locations[x].length - 1);
            if (this.location.getLocationCount() == locations[x][y].getLocationCount()) {
                y = Math.max(y - this.speed, 0);
            }
        }
        if (random == 2) { //двигаемся вверх
            x = Math.max(x - this.speed, 0);
            if (this.location == locations[x][y]) {
                x = Math.min(x + this.speed, locations.length - 1);
            }
        }
        if (random == 3) { //двигаемся вниз
            x = Math.min(x + this.speed, locations.length - 1);
            if (this.location.getLocationCount() == locations[x][y].getLocationCount()) {
                x = Math.max(x - this.speed, 0);
            }

        }

        String toStatistic = (this.getType() + " переместился из Локации -" +
                this.getLocation().getLocationCount() +
                " в локацию - " + locations[x][y].getLocationCount());
        this.location.removeAnimal(this);
        locations[x][y].

                addAnimal(this);
        Statistics.putToMoveStat(toStatistic);
    }

    public void reproduce() {
        if (checkMaxCountOnLocation()) {
            int count = 0;
            for (Animal animal : this.location.getAnimals()) {
                if (this.type.equals(animal.getType())) {
                    count++;
                }
            }
            if (count >= 2) {
                for (int i = 0; i < count / 2; i++) {
                    if (checkMaxCountOnLocation()) {
                        this.location.addAnimal(AnimalFactory.createAnimal(this.type));
                    }
                }
                String toStatistic = "В локации - " + this.getLocation().getLocationCount() +
                        ",У " + count + " " + this.getType() + " родилось: " + count / 2 + " " + getType();
                Statistics.putToReproduceStat(toStatistic);
            }
        }
    }

    public void newDay() {
        currentSatiety = currentSatiety - this.getHunger();
        if (currentSatiety < 0) {
            this.location.removeAnimal(this);
            String toStatistics = "В локации - " + this.getLocation().getLocationCount() +
                    " умер от голода " + this.getType();
            Statistics.putToReproduceStat(toStatistics);
            if (this instanceof Predator) Island.decrementPredatorCount();
        }
    }

    private boolean checkMaxCountOnLocation() {
        int currentCountThisType = 0;
        int currentCountAllAnimals = this.getLocation().getAnimals().size();
        for (Animal animal : this.getLocation().getAnimals()) {
            if (this.getType().equals(animal.getType())) {
                currentCountThisType++;
            }
        }
        return currentCountThisType < this.maxCountOnLocation && currentCountAllAnimals < OptionIsland.NUMBER_ANIMAL_IN_LOCATION;
    }

    public boolean isHungry() {
        return (currentSatiety < fullSatiety);
    }

    //setter and getters
    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public AnimalType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getCurrentSatiety() {
        return currentSatiety;
    }

    public void setCurrentSatiety(double currentSatiety) {
        this.currentSatiety = currentSatiety;
    }

    public double getHunger() {
        return hunger;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public double getFullSatiety() {
        return fullSatiety;
    }

    //Override
    @Override
    public String toString() {
        return ICO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return type == animal.type;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }


}
