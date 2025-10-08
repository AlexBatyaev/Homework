public class Park {

    public class Attraction {
        private String name;
        private String openingTime;
        private String closingTime;
        private double price;

        public Attraction(String name, String openingTime, String closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getOpeningTime() {
            return openingTime;
        }

        public String getClosingTime() {
            return closingTime;
        }

        public double getPrice() {
            return price;
        }

        public void printAttractionInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + openingTime + " - " + closingTime);
            System.out.println("Стоимость: " + price);
            System.out.println("-------");
        }
    }

    // Пример использования внутреннего класса
    public static void main(String[] args) {
        Park park = new Park(); // Необходимо создать экземпляр Park, чтобы использовать внутренний класс
        Attraction rollerCoaster = park.new Attraction("Американские горки", "10:00", "22:00", 500.0); // Исправлено
        Attraction ferrisWheel = park.new Attraction("Колесо обозрения", "11:00", "21:00", 300.0);      // Исправлено

        rollerCoaster.printAttractionInfo();
        ferrisWheel.printAttractionInfo();
    }
}
