package main;

import animals.*;

import java.util.HashSet;

public class Island {
    public Location[][] locations;

    public Island() {
        locations = new Location[OptionIsland.HEIGHT_ISLAND][OptionIsland.WIDTH_ISLAND];
        initialize();
    }

    private void initialize() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
    }

    public void printLocations() {
        for (Location[] location : locations) {
            for (Location value : location) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


   /* public static void reproduceAnimals() {
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

    public static void moveAnimals() {
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Animal animal : location1.getAnimals()) {
                    animal.move(locations);
                }
            }
        }
    }

    public static void animalEat() {
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Animal animal : location1.getAnimals()) {
                    animal.eat();
                }
            }
        }
    }

    public static void newDayForAnimals() {
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Animal animal : location1.getAnimals()) {
                    animal.newDay();
                }
            }
        }
    }*/
}

