package homeworkFive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopTwo implements ShopInterface {
    private Map<Product, Integer> mapProduct = new HashMap<>();

    public Map<Product, Integer> getMapProduct() {
        return mapProduct;
    }

    public void addProductShop(Product product) {
        //mapProduct.put(product, count);
        if (!mapProduct.containsKey(product)) {
            mapProduct.put(product, 1);
        } else {
            mapProduct.put(product, mapProduct.get(product) + 1);
        }
    }

    public Map<String, Integer> getCheck(List<Integer> list) {
        Map<String, Integer> mapCheck = new HashMap();
        String nameProduct = "";
        int count;
        for (Map.Entry<Product, Integer> p : mapProduct.entrySet()) {
            count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == p.getKey().getId()) {
                    count++;
                    nameProduct = p.getKey().getName();
                    mapCheck.put(nameProduct, count);
                }
            }
            mapProduct.put(p.getKey(), p.getValue() - count);
        }
        return mapCheck;
    }

    public double getTotalPrice(List<Integer> list) {
        double sum = 0;
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            for (Map.Entry<Product, Integer> p : mapProduct.entrySet()) {
                if (list.get(i) == p.getKey().getId()) {
                    total = p.getKey().getPrice();
                }
            }
            sum += total;
        }
        return sum;
    }

    public void printCheck(List<Integer> list) {
        Map<String, Integer> mapRez = getCheck(list);
        System.out.println("  Check:");
        System.out.println("------------------------");
        for (Map.Entry<String, Integer> map : mapRez.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue() + "шт.");
        }
        System.out.println("------------------------");
        System.out.println("  Total: " + getTotalPrice(list));
    }

}
