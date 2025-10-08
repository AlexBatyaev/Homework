import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Samsung S25 Ultra", new Date(2025 - 1900, 1, 1), "Samsung Corp.", "Korea", 5599.0, true);
        productsArray[1] = new Product("iPhone 17 Pro", new Date(2025 - 1900, 2, 15), "Apple Inc.", "USA", 6299.0, false);
        productsArray[2] = new Product("Xiaomi Mi 15", new Date(2025 - 1900, 0, 20), "Xiaomi Inc.", "China", 3499.0, true);
        productsArray[3] = new Product("Sony Xperia Z10", new Date(2024 - 1900, 11, 1), "Sony Corp.", "Japan", 4899.0, false);
        productsArray[4] = new Product("Google Pixel 10", new Date(2025 - 1900, 3, 5), "Google LLC", "USA", 5999.0, true);

                for (Product product : productsArray) {
            product.printInfo();
        }
    }
}