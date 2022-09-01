package main;

import animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Location {
    private static int count = 1;
    private final int locationCount;
    private final List<Animal> animals;
    private final List<Plant> plants;
    private final int positionX;
    private final int positionY;

    public Location(int positionX, int positionY) {
        plants = new ArrayList<>();
        animals = new CopyOnWriteArrayList<>();
        locationCount = count;
        count++;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void addPlants() {
        plants.add(new Plant());
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animal.setLocation(this);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }



    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Plant> getPlants() {
        return plants;
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

    @Override
    public String toString() {
        return "L" + locationCount + animals + plants;
    }

}
