package homeworkFive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFileWriteJSON {
    private List<String> listProduct = new ArrayList<>();


    public void addProductInFile(Product product, String fileName) throws IOException {
        if ((listProduct.size() == 0 && (overwriteExistingProducts(fileName).length() == 0))) {
            listProduct.add("[\n");
        }
        String string = product.toJSON();
        if (listProduct == null) {
            listProduct.add(string + ",\n");
        } else {
            listProduct.add(string + "\n]");
        }

        fileWrite(fileName);
    }

    public void addProductInFile(List<Product> product, String fileName) throws IOException {

        for (int i = 0; i < product.size(); i++) {
            if ((listProduct.size() == 0 && (overwriteExistingProducts(fileName).length() == 0))) {
                listProduct.add("[\n");
            }
            String string = product.get(i).toJSON();
            if (i < product.size() - 1) {
                listProduct.add(string + ",\n");
            } else {
                listProduct.add(string + "\n]");
            }
        }
        fileWrite(fileName);
    }

    private void fileWrite(String fileName) throws IOException {
        String string = overwriteExistingProducts(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        if (string != null) {
            bufferedWriter.write(string);
        }
        for (int i = 0; i < listProduct.size(); i++) {
            bufferedWriter.append(listProduct.get(i));
        }
        bufferedWriter.close();
        listProduct = new ArrayList<>();
    }

    private String overwriteExistingProducts(String fileName) {
        String str;
        String rez = "";
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            do {
                str = bufferedReader.readLine();
                if (str != null) {
                    rez += str + "\n";
                } else if (rez.length() != 0) {
                    rez = rez.substring(0, rez.length() - 3);
                    rez += ",\n";
                }
            } while (str != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rez;
    }
}
