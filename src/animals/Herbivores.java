package animals;


import main.Plant;
import main.Statistics;

import java.util.List;

public abstract class Herbivores extends Animal {


    protected Herbivores(String ico, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        super(ico, weight, type, speed, satiety, maxCountOnLocation);
    }

    @Override
    public void eat() {
        List<Plant> plants = this.getLocation().getPlants();
        int count = 0;
        while (!plants.isEmpty() && isHungry()) {
            setCurrentSatiety(Math.min(getCurrentSatiety() + Plant.WEIGHT, getFullSatiety()));
            plants.remove(plants.size() - 1);
            count++;
        }
        // переделать на передачу в статистику
        if (count > 0){
            String toStatistic = (this.getType() + " в локации "+ this.getLocation().getLocationCount() + " съел растений: " + count);
            Statistics.putToEatStat(toStatistic);
        }
    }

}
