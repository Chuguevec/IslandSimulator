package main;

import animals.*;

import java.util.HashSet;

public class Island {
    public static Location[][] locations = new Location[8][8];

    public static void main(String[] args) {


        for (int x = 0; x < locations.length; x++) {
            for (int y = 0; y < locations[x].length; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
        Location location = locations[3][3];
        Wolf wolf = new Wolf();
        Boa boa = new Boa();
        location.addAnimal(new Rabbit());
        location.addAnimal(new Rabbit());
        location.addAnimal(wolf);
        location.addAnimal(new Wolf());
        location.addAnimal(boa);
        location.addPlants();
        location.addPlants();

        location.addAnimal(new Boa());

        for (int i = 0; i < 10; i++) {
            printLocations();
            animalEat();
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
    public static void animalEat (){
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
    }
}
