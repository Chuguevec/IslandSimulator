package main;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Island island = new Island();
        Actions actions = new Actions(island);

        island.printLocations();
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.scheduleAtFixedRate(actions.getGrowthPlants(), 1, 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(actions.getAllAnimalsToDo(), 1, 3, TimeUnit.SECONDS);

        //Условие выхода из симуляции
        Runnable checkExit = new Runnable() {
            @Override
            public void run() {
                int predatorCount = Island.getPredatorCount();
                if (predatorCount == 0) {
                    Actions.esShutDown();
                    System.out.println("Все хищники погибли");
                    executorService.shutdown();
                }
            }
        };

        executorService.scheduleAtFixedRate(checkExit, 21, 3, TimeUnit.SECONDS);


    }
}

