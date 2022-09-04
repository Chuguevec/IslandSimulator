package main;

import animals.Animal;
import animals.Predator;

import java.util.HashSet;
import java.util.concurrent.*;

public class Actions {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(3);
    private final Island island;
    private final Location[][] locations;
    private static int dayCount = 1;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

    public Actions(Island island) {
        this.island = island;
        locations = island.locations;
    }


    //Таски
    //Рост растений
    public Runnable getGrowthPlants (){
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < OptionIsland.NUMBER_PLANT_GROWTH_1DAY; i++) {
                    island.randomLocation().addPlants();
                }
            }
        };
    }

    //Таск - Новый день
    public void newDayForAnimals() {
        dayCount++;
        for (Location[] location : locations) {
            for (Location location1 : location) {
                for (Animal animal : location1.getAnimals()) {
                    animal.newDay();
                }
            }
        }
    }

    //Запуск всех действий животного
    public Runnable getAllAnimalsToDo(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("День: " + dayCount);
                island.printLocations();
                executorService.execute(getMoveAnimals());
                executorService.execute(getEatAnimals());
                executorService.execute(getReproduceAnimal());

                try {
                    cyclicBarrier.await();
                    newDayForAnimals();
                    Statistics.showStatistic();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    //Таск - перемещаться
    private Runnable getMoveAnimals() {
        return new Runnable() {
            @Override
            public void run() {
                for (Location[] location : locations) {
                    for (Location location1 : location) {
                        for (Animal animal : location1.getAnimals()) {
                            animal.move(locations);
                        }
                    }
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        };
    }

    //Таск - кушать
    private Runnable getEatAnimals() {
        return new Runnable() {
            @Override
            public void run() {
                for (Location[] location : locations) {
                    for (Location location1 : location) {
                        for (Animal animal : location1.getAnimals()) {
                            animal.eat();
                        }
                    }
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
    }
        //Таск - Размножение
    private Runnable getReproduceAnimal() {
         return new Runnable() {
            @Override
            public void run() {
                HashSet<Animal> uniqueAnimals = new HashSet<>();
                for (Location[] location : locations) {
                    for (Location location1 : location) {
                        uniqueAnimals.addAll(location1.getAnimals());
                    }
                }
                for (Animal uniqueAnimal : uniqueAnimals) {
                    uniqueAnimal.reproduce();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        };
    }


}

