public class InterfaceMain {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "Красный", "Черный");
        Rectangle rectangle = new Rectangle(4, 6, "Синий", "Зеленый");
        Triangle triangle = new Triangle(3, 4, 5, "Желтый", "Оранжевый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}
