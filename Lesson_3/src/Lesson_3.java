// Задание 1

// Базовый класс для всех животных
class Animal {
    String name;
    static int animalCount = 0;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }

    static int getAnimalCount() {
        return animalCount;
    }
}

// Класс Собака, наследуется от Животного
class Dog extends Animal {
    static int dogCount = 0;
    private final int maxRunDistance = 500;
    private final int maxSwimDistance = 10;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    void run(int distance) {
        if (distance <= maxRunDistance) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция: " + maxRunDistance + " м.");
        }
    }

    @Override
    void swim(int distance) {
        if (distance <= maxSwimDistance) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. Максимальная дистанция: " + maxSwimDistance + " м.");
        }
    }

    static int getDogCount() {
        return dogCount;
    }
}

// Класс Кот, наследуется от Животного
class Cat extends Animal {
    static int catCount = 0;
    private final int maxRunDistance = 200;
    private boolean isFull = false; // Изначально кот голоден
    Cat(String name) {
        super(name);
        catCount++;
    }
    static int getCatCount() {
        return catCount;
    }
    @Override
    void run(int distance) {
        if (distance <= maxRunDistance) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. Максимальная дистанция: " + maxRunDistance + " м.");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Plate plate) {
        if (plate.getFoodAmount() >= 10) { // Упрощенная логика - коту нужно 10 еды для насыщения
            plate.decreaseFood(10);
            isFull = true;
            System.out.println(name + " поел и теперь сыт.");
        } else {
            System.out.println(name + " не стал есть, так как в миске мало еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }
}

// Класс Миска
class Plate {
    private int foodAmount;

    Plate(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void decreaseFood(int amount) {
        foodAmount -= amount;
        if (foodAmount < 0) {
            foodAmount = 0; // Не допускаем отрицательное количество еды
        }
    }


    public void addFood(int amount) {
        foodAmount += amount;
        System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount);
    }
}


// Задание 2

// Интерфейс для геометрических фигур
interface Shape {
    double calculatePerimeter();
    double calculateArea();
    String getFillColor();
    String getBorderColor();

    default String getDescription() { // Пример дефолтного метода
        return "Фигура: [" + this.getClass().getSimpleName() + "], Периметр: " + calculatePerimeter() + ", Площадь: " + calculateArea() + ", Цвет фона: " + getFillColor() + ", Цвет границы: " + getBorderColor();
    }
}

// Класс Круг, реализует интерфейс Shape
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс Прямоугольник, реализует интерфейс Shape
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс Треугольник, реализует интерфейс Shape
class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        // Формула Герона
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}


public class Lesson_3 {
    public static void main(String[] args) {
        // Задание 1. Тестирование
        Dog dogBobik = new Dog("Бобик");
        Cat catBarsik = new Cat("Барсик");
        Dog dogSharik = new Dog("Шарик");


        dogBobik.run(400);
        dogBobik.swim(8);
        catBarsik.run(150);
        catBarsik.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());


        Plate plate = new Plate(50);
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Том");
        cats[2] = new Cat("Леопольд");

        for (Cat cat : cats) {
            cat.eat(plate);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт? " + cat.isFull());
        }

        plate.addFood(30);

        // Задание 2. Тестирование
        Shape circle = new Circle(5, "Красный", "Черный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Оранжевый");

        System.out.println(circle.getDescription());
        System.out.println(rectangle.getDescription());
        System.out.println(triangle.getDescription());


    }
}