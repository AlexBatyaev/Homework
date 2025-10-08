public class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name, 200, 0);
        this.satiety = false;
        catCount++;
    }

    public void eat(Plate plate, int foodAmount) {
        if (plate.getFoodAmount() >= foodAmount) {
            plate.decreaseFood(foodAmount);
            satiety = true;
            System.out.println(name + " поел " + foodAmount + " еды.");
        } else {
            System.out.println(name + " не поел. Недостаточно еды в миске.");
            satiety = false;

        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}