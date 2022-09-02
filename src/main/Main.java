package main;

import animals.Boa;
import animals.Rabbit;
import animals.Wolf;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        island.printLocations();

//        for (int i = 0; i < 10; i++) {
//            printLocations();
//            animalEat();
//            System.out.println();
//            newDayForAnimals();
//        }
//        printLocations();

    }
}
