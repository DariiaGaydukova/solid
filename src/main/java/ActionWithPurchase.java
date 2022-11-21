import java.util.Map;

public class ActionWithPurchase {

    protected Purchase[] purchases;
    Map<String, Integer> products;

    public ActionWithPurchase(Map<String, Integer> products) {
        this.products = products;
        purchases = new Purchase[products.size()];

    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public void printProduct(Map<String, Integer> prices) { //разделила метод на 2
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("ИТОГО:" + "\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");

        }
    }

    public long sum(Map<String, Integer> prices) {  //отдельный метод для просчета общей сумму
        long sum = 0;
        for (Purchase purchase : purchases) {
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
