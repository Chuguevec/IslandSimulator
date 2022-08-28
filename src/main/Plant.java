package main;

public class Plant {
    public static final String ICO = "\uD83C\uDF3F";
    public static final int WEIGHT = 1;
    public static final String NAME ="Растений";
    public final String ico;


    public Plant() {
        this.ico = ICO;
    }

    @Override
    public String toString() {
        return ICO;
    }
}
