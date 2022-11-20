import java.util.Map;

public class Purchase {
    protected String title;
    protected int count;
    protected Purchase[] purchases = new Purchase[Main.products.size()]; //заменила магическое число

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public Purchase() {
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


