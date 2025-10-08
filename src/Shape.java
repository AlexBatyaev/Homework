interface Shape {
    double calculatePerimeter();  // Обязательный метод для расчета периметра
    double calculateArea();      // Обязательный метод для расчета площади

    String getFillColor();
    String getBorderColor();

    void setFillColor(String color);
    void setBorderColor(String color);

    default void printInfo() { // Дефолтный метод для вывода информации
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println("-------");
    }
}