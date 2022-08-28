package animals;


import main.Plant;
import java.util.List;

public class Herbivores extends Animal {


    protected Herbivores(String ico, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        super(ico, weight, type, speed, satiety, maxCountOnLocation);
    }

    @Override
    public void eat() {
        List<Plant> plants = this.getLocation().getPlants();
        int count = 0;
        while (!plants.isEmpty() && this.getCurrentSatiety() < this.getFullSatiety()) {
            setCurrentSatiety(getCurrentSatiety() + Plant.WEIGHT);
            plants.remove(plants.size() - 1);
            count++;
        }
        // переделать на передачу в статистику
        if (count > 0) System.out.println(this.getType() + " в локации "+ this.getLocation().getLocationCount() + " съел растений: " + count);
    }

}
