package animals;

import root.Location;

public abstract class Animal {
    private final String ICO;
    private final double weight;
    private final int speed;
    private final AnimalType type;
    private final int maxCountOnLocation;
    private Location location;
    private double satiety;
    private final double hunger; // Голод. На эту единицу будет уменьшаться насыщение (satiety)
    private boolean reproduceToday;

    public boolean isReproduceToday() {
        return reproduceToday;
    }

    public void setReproduceToday(boolean reproduceToday) {
        this.reproduceToday = reproduceToday;
    }

    protected Animal(String ico, Location location, double weight, AnimalType type, int speed, double satiety, int maxCountOnLocation) {
        ICO = ico;
        this.location = location;
        this.weight = weight;
        this.type = type;
        this.speed = speed;
        hunger = satiety/9;
        this. satiety = satiety/2;
        this.maxCountOnLocation = maxCountOnLocation;
        reproduceToday = false;
    }

    public abstract void eat() ;


    public void move(Location [][] locations) {
        int x = location.getPositionX();
        int y = location.getPositionY();
        int random = (int) (Math.random() * 4);  // получаем случайное число от 0 до 4 для выбора движения
        switch (random) {
            case 0 -> { //двигаемся влево
                if (y - this.speed < 0) y = 0;
                else y = y - this.speed;
            }
            case 1 -> { //двигаемся вправо
                if (y + this.speed > locations[x].length-1) y = locations[x].length - 1;
                else y = y + this.speed;
            }
            case 2 -> { //двигаемся вверх
                if (x - this.speed < 0) x = 0;
                else x = x - this.speed;
            }
            case 3 -> { //двигаемся вниз
                if (x + this.speed > locations.length-1) x = locations.length - 1;
                else x = x + this.speed;
            }
        }
        this.location.removeAnimal( this);
        locations[x][y].addAnimal(this);
    }
    public void reproduce(){
        int count =0;
        for (Predator predator : this.location.getPredators()) {
            if (this.type.equals(predator.getType()) && !predator.isReproduceToday()){
                count++;
                predator.setReproduceToday(true);
            }
        }
        if (count >= 2) {
            for (int i = 0; i < count/2; i++) {
                this.location.addAnimal(AnimalFactory.createAnimal(this.type, this.location));
            }

        }
    }



    @Override
    public String toString() {
        return ICO;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public AnimalType getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getSatiety() {
        return satiety;
    }

    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }
    public void newDay (){
        satiety = satiety - this.getHunger();
        if (satiety <= 0){
            this.location.removeAnimal(this);
        }
        reproduceToday = false;
    }

    public double getHunger() {
        return hunger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return type == animal.type;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }
}