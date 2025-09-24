

public class Lesson_2 {

    public static void main(String[] args) {
        // 1. Создание массива товаров
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("IPhone 17 Pro", "15.01.2025", "Apple Inc.", "USA", 6200, false);
        productsArray[2] = new Product("Xiaomi Mi 15", "01.03.2025", "Xiaomi Inc.", "China", 3800, true);
        productsArray[3] = new Product("Google Pixel 10", "20.02.2025", "Google LLC.", "USA", 5000, false);
        productsArray[4] = new Product("OnePlus 13", "10.02.2025", "OnePlus Technology", "China", 4200, true);

        // Вывод информации о каждом товаре
        for (Product product : productsArray) {
            product.displayInfo();
            System.out.println("-------");
        }

        // Пример использования класса Park
        Park myPark = new Park("Central Park");

        // Добавление аттракционов
        myPark.addAttraction("Roller Coaster", "10:00-22:00", 500);
        myPark.addAttraction("Ferris Wheel", "11:00-23:00", 300);

        // Вывод информации о парке и его аттракционах
        myPark.displayParkInfo();
    }
}


class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price);
        System.out.println("Забронирован: " + isReserved);
    }
}

class Park {
    private String name;
    private Attraction[] attractions;
    private int attractionCount;
    private static final int MAX_ATTRACTIONS = 10;

    public Park(String name) {
        this.name = name;
        this.attractions = new Attraction[MAX_ATTRACTIONS];
        this.attractionCount = 0;
    }

    public void addAttraction(String name, String operatingHours, double cost) {
        if (attractionCount < MAX_ATTRACTIONS) {
            attractions[attractionCount] = new Attraction(name, operatingHours, cost);
            attractionCount++;
        } else {
            System.out.println("Парк переполнен! Нельзя добавить больше аттракционов.");
        }
    }

    public void displayParkInfo() {
        System.out.println("Парк: " + name);
        System.out.println("Аттракционы:");
        for (int i = 0; i < attractionCount; i++) {
            attractions[i].displayAttractionInfo();
        }
    }

    //Внутренний класс для представления аттракционов
    class Attraction {
        private String name;
        private String operatingHours;
        private double cost;

        public Attraction(String name, String operatingHours, double cost) {
            this.name = name;
            this.operatingHours = operatingHours;
            this.cost = cost;
        }

        public void displayAttractionInfo() {
            System.out.println("  Название аттракциона: " + name);
            System.out.println("  Время работы: " + operatingHours);
            System.out.println("  Стоимость: " + cost);
        }
    }
}
