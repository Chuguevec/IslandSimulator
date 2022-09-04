package main;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Statistics {
    private static final List<String> moveStatistic = new CopyOnWriteArrayList<>();
    private static final List<String> eatStatistic = new CopyOnWriteArrayList<>();
    private static final List<String> reproduceStatistic = new CopyOnWriteArrayList<>();

    public static void putToEatStat (String s){
        if (s != null){
            eatStatistic.add(s);
        }
    }
    public static void putToReproduceStat (String s){
        if (s != null){
            reproduceStatistic.add(s);
        }
    }
    public static void putToMoveStat (String s){
        if (s != null){
            moveStatistic.add(s);
        }
    }

    public static void showStatistic (){
        System.out.println();
        reproduceStatistic.forEach(System.out::println);
        System.out.println();
        eatStatistic.forEach(System.out::println);
        if (OptionIsland.SHOW_MOVE_STATISTIC){
            System.out.println();
            moveStatistic.forEach(System.out::println);
        }
        eatStatistic.clear();
        reproduceStatistic.clear();
        moveStatistic.clear();
    }

}
