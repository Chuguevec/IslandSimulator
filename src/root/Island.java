package root;

import animals.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Island {
    public static Location[][] locations = new Location[8][8];

    public static void main(String[] args) {


        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
        Location location = locations[3][3];
        Wolf wolf = new Wolf(location);
        Boa boa = new Boa(location);
        location.addAnimal(wolf);
        location.addAnimal(new Wolf(location));
        location.addAnimal(boa);
        location.addAnimal(new Boa(location));

        for (int i = 0; i < 10; i++) {
            printLocations();
            reproduceAnimals();
            System.out.println();
            newDayForAnimals();
        }
        printLocations();

    }

    public static void printLocations() {
        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                System.out.print(locations[x][y] + "\t");
            }
            System.out.println();
        }
    }

    public static void reproduceAnimals() {
        HashSet<Predator> uniquePredators = new HashSet<>();
        HashSet<Herbivores> uniqueHerbivores = new HashSet<>();

        for (Location[] location : locations) {
            for (Location location1 : location) {
                uniquePredators.addAll(location1.getPredators());
                uniqueHerbivores.addAll(location1.getHerbivores());
            }
        }
        for (Predator uniquePredator : uniquePredators) {
            uniquePredator.reproduce();
        }
        for (Herbivores uniqueHerbivore : uniqueHerbivores) {
            uniqueHerbivore.reproduce();
        }
    }

    public static void moveAnimals() {
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Predator predator : location1.getPredators()) {
                    predator.move(locations);
                }
                for (Herbivores herbivore : location1.getHerbivores()) {
                    herbivore.move(locations);
                }
            }
        }
    }

    public static void newDayForAnimals() {
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Predator predator : location1.getPredators()) {
                    predator.newDay();
                }
                for (Herbivores herbivore : location1.getHerbivores()) {
                    herbivore.newDay();
                }
            }
        }
    }
}
