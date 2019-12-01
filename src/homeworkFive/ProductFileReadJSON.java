package homeworkFive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductFileReadJSON {

    private static List<Product> productsList = new ArrayList<>();

    private List<Product> createProducts(String productsString) {
        String[] split = productsString.split("},\\{");

        List<String> processedString = new ArrayList<>();
        for (String s1 : split) {
            processedString.add(s1.replaceAll("\\{", "").replaceAll("}", ""));
        }
        List<Product> products = new ArrayList<>();
        for (String s1 : processedString) {
            products.add(createProduct(s1));
        }
        return products;
    }

    private Product createProduct(String productsString) {
        String[] pairs = productsString.split(",");

        String[] split0 = pairs[0].split(":");
        String[] split1 = pairs[1].split(":");
        String[] split2 = pairs[2].split(":");
        String[] split3 = pairs[3].split(":");
        Product product = null;
        if ("\"Mouse\"".equals(split0[1])) {
            product = new Mouse(Integer.parseInt(split1[1]), split2[1], Integer.parseInt(split3[1]));
        } else if ("\"Monitor\"".equals(split0[1])) {
            product = new Monitor(Integer.parseInt(split1[1]), split2[1], Integer.parseInt(split3[1]));
        } else if ("\"Keyboard\"".equals(split0[1])) {
            product = new Keyboard(Integer.parseInt(split1[1]), split2[1], Integer.parseInt(split3[1]));
        }
        return product;
    }

    public List<Product> createLispProductFile(String fileName) {
        String accumulator = "";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String string = "";
            while (string != null) {
                string = bufferedReader.readLine();
                if (string == null) break;
                accumulator += string;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        accumulator = accumulator.replace("[", "");
        accumulator = accumulator.replace("]", "");
        accumulator = accumulator.replaceAll(" ", "");

        productsList = createProducts(accumulator);
        return productsList;
    }
}
