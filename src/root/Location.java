package root;

import animals.Animal;
import animals.Herbivores;
import animals.Predator;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private static int count = 1;
    private final int locationCount;
   private final List <Predator> predators;
   private final List <Herbivores> herbivores;
   private final List <Plant> plants;
   private final int positionX;
   private final int positionY;

    public Location(int positionX, int positionY) {
        plants = new ArrayList<>();
        predators = new CopyOnWriteArrayList<>();
        herbivores = new CopyOnWriteArrayList<>();
        locationCount = count;
        count++;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "L" + locationCount + predators + herbivores + plants;
    }

    public void addAnimal  (Animal animal){
        if (animal instanceof Predator){
            predators.add((Predator) animal);
        }else if (animal instanceof Herbivores){
            herbivores.add((Herbivores) animal);
        }
        animal.setLocation(this);
    }
    public void removeAnimal  (Animal animal){
        if (animal instanceof Predator){
            predators.remove((Predator) animal);
        }else if (animal instanceof Herbivores){
            herbivores.remove((Herbivores) animal);
        }
    }

    public void addPlants (Plant plant){
        plants.add(plant);
    }

    public List<Predator> getPredators() {
        return predators;
    }

    public List<Herbivores> getHerbivores() {
        return herbivores;
    }

    public int getLocationCount() {
        return locationCount;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
