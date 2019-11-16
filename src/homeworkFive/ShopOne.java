package homeworkFive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopOne implements ShopInterface {
    private List<Product> productList = new ArrayList<>();

    public void addProductShop(Product product) {
        productList.add(product);
    }

    public Map<String, Integer> getCheck(List<Integer> list) {
        Map<String, Integer> map = new HashMap();
        String nameProduct = "";
        int count;
        for (int i = 0; i < productList.size(); i++) {
            count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == productList.get(i).getId()) {
                    count++;
                    nameProduct = productList.get(i).getName();
                    map.put(nameProduct, count);
                }
            }
        }
        return map;
    }

    public double getTotalPrice(List<Integer> list) {
        double sum = 0;
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < productList.size(); j++) {
                if (list.get(i) == productList.get(j).getId()) {
                    total = productList.get(j).getPrice();
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
