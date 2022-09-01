package main;

import animals.Boa;
import animals.Rabbit;
import animals.Wolf;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();

        Location location = island.locations[3][3];
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

//        for (int i = 0; i < 10; i++) {
//            printLocations();
//            animalEat();
//            System.out.println();
//            newDayForAnimals();
//        }
//        printLocations();

    }
}
