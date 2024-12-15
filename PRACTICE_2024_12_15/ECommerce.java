package PRACTICE_2024_12_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ECommerce {

    public static void main(String[] args) {

        // {"Laptop" = { "Price" = 1500, "Stock" = 15 }, "Tablet" = { "Price" = 1000, "Stock" = 10 }}

        HashMap<String, Map<String, Integer>> products = new HashMap<>();

        products.put("Laptop", new HashMap<>() {{
            put("Price", 1500);
            put("Stock", 15);
        }});

        products.put("Tablet", new HashMap<>() {{
            put("Price", 700);
            put("Stock", 10);
        }});

        HashMap<String, Integer> basket = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n==== E-ticaret Sepet Yönetimi");
            System.out.println("1. Ürünleri Listele");
            System.out.println("2. Sepete Ürün Ekle");
            System.out.println("3. Sepetten Ürün Çıkar");
            System.out.println("4. Sepeti Görüntüle");
            System.out.println("5. Çıkış");
            System.out.println("Seçimizi yapınız: ");

            int select = sc.nextInt();
            sc.nextLine();

            switch (select) {
                case 1 -> listProduct(products);
                case 2 -> addToBasket(sc, products, basket);
//                case 3 -> removeFromBasket();
//                case 4 -> viewBasket();
                case 5 -> {
                    System.out.println("Çıkış yapılıyor...");
                    return;
                }
                default -> System.out.println("Geçersiz seçim! Lütfen tekrar seçim yapınız.");
            }
        }
    }

    private static void addToBasket(Scanner sc, HashMap<String, Map<String, Integer>> products, HashMap<String, Integer> basket) {

        System.out.println("\n Sepete eklemek istediğiniz ürün ismini giriniz:");
        String productName = sc.nextLine();

        if (!products.containsKey(productName)) {
            System.out.println("Ürün bulunamadı!");
            return;
        }

        System.out.println("Üründen kaç adet almak istiyorsunuz:");
        int quantity = sc.nextInt();
        sc.nextLine();

        // {"Laptop" = { "Price" = 1500, "Stock" = 15 }, "Tablet" = { "Price" = 1000, "Stock" = 10 }}

        int stock = products.get(productName).get("Stock");

        if (stock < quantity) {
            System.out.println("Yeterli ürün yok");
        }
        else {
            basket.put(productName, quantity);
            products.get(productName).put("Stock", stock-quantity);
            System.out.println(quantity + " adet " + productName + " sepete başarıyla eklendi.");
        }
    }

    private static void listProduct(HashMap<String, Map<String, Integer>> products) {

        System.out.println("Mevcut Ürünler: \n");

        for (var entry : products.entrySet()) {

            // {"Laptop" = { "Price" = 1500, "Stock" = 15 }, "Tablet" = { "Price" = 700, "Stock" = 10 }}

            String productName = entry.getKey();
            int price = entry.getValue().get("Price");
            int stock = entry.getValue().get("Stock");

            System.out.println("\t" + productName + "\t" + "Price: " + price + " $ " + "\t" + "Stock: " + stock);

        }
    }
}
