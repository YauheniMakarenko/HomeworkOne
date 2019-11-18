package homeworkFive;

import java.util.HashMap;
import java.util.Map;

public class Check {
    private Map<Product, Integer> mapCheak = new HashMap<>();
    private double sum = 0;

    public void generateCheck() {
        System.out.println(" Check");
        System.out.println("---------------------------");
        for (Map.Entry<Product, Integer> p : mapCheak.entrySet()) {
            System.out.println(p.getKey().getName() + " " + p.getValue() + "шт.");
        }
        System.out.println("---------------------------");
        System.out.println(" Price: " + sum);
    }

    public void addProductInCheck(Product product) {
        if (!mapCheak.containsKey(product)) {
            mapCheak.put(product, 1);
            sum += product.getPrice();
        } else {
            mapCheak.replace(product, mapCheak.get(product) + 1);
            sum += product.getPrice();
        }
    }
}
