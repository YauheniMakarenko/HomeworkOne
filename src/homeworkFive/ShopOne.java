package homeworkFive;

import java.util.ArrayList;
import java.util.List;

public class ShopOne implements ShopInterface  {

    private List<Product> productList = new ArrayList<>();

    public void addProductShop(Product product) {
        if (productList.contains(product)) return;
        productList.add(product);
    }

    public void addProductShop(List<Product> list){
        for (int i = 0; i < list.size(); i++) {
            addProductShop(list.get(i));
        }
    }

    public Check getCheck(List<Integer> list) {
        if (list == null) {
            return null;
        }
        Check check = new Check();
        for (int i = 0; i < productList.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == productList.get(i).getId()) {
                    check.addProductInCheck(productList.get(i));
                }
            }
        }
        return check;
    }

    public void printCheck(Check check) {
        check.generateCheck();
    }
}
