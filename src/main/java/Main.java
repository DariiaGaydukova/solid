import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static HashMap<String, Integer> products = new HashMap<>();

    public static void main(String[] args) {

        productWindow(products); //отдельный метод для продуктовой ветрины

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);

        ActionWithPurchase actionWithPurchase = new ActionWithPurchase(products);
        Purchase purchase = new Purchase();
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            actionWithPurchase.addPurchase(product, count);
        }
        actionWithPurchase.printProduct(products);
        System.out.println("ИТОГО " + actionWithPurchase.sum(products));

    }


    public static HashMap<String, Integer> productWindow(HashMap<String, Integer> products) {
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        return products;
    }
}