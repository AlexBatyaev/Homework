public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(400);
        catMurzik.swim(5);
        catBarsik.run(300);

        System.out.println("Создано животных: " + Animal.getAnimalCount());
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());

        // Миска и коты
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Том");
        cats[1] = new Cat("Леопольд");
        cats[2] = new Cat("Матроскин");

        for (Cat cat : cats) {
            cat.eat(plate, 20);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        plate.addFood(30);
        cats[0].eat(plate,50);
        System.out.println(cats[0].getName() + " сыт: " + cats[0].isSatiety());

    }
}