package homeworkFive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopOne implements ShopInterface  {

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList = new ArrayList<>();

    public void addProductShop(Product product) {
        productList.add(product);
    }

    public Check getCheck(List<Integer> list) {
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
