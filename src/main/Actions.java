package main;

import animals.Animal;

import java.util.HashSet;

public class Actions {
    private Island island;
    private Location [] [] locations;

    public Actions (Island island) {
        this.island = island;
        locations = island.locations;
    }

    public class  GrowthPlants implements Runnable {

        @Override
        public void run() {
            growthPlants();
        }

        public void growthPlants (){
            for (int i = 0; i < OptionIsland.NUMBER_PLANT_GROWTH_1DAY; i++) {
                island.randomLocation().addPlants();
            }
        }
    }

    public class ActionsAnimal implements Runnable{
        @Override
        public void run() {
            reproduceAnimals();
        }

        public void reproduceAnimals() {
            HashSet<Animal> uniqueAnimals = new HashSet<>();
            for (Location[] location : locations) {
                for (Location location1 : location) {
                    uniqueAnimals.addAll(location1.getAnimals());
                }
            }
            for (Animal uniqueAnimal : uniqueAnimals) {
                uniqueAnimal.reproduce();
            }

        }
    }
}
