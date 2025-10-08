public class Plate {
    private int foodAmount;

    public Plate(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        foodAmount -= amount;
        if (foodAmount < 0) {
            foodAmount = 0;
        }
        System.out.println("В миске осталось " + foodAmount + " еды.");
    }

    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавили " + amount + " еды.  Теперь в миске " + foodAmount);
    }
}