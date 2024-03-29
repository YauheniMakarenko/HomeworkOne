package homeworkFive;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFileWriteJSON {

    public void addProductInFile(Product product, String fileName) throws IOException {
        List<String> listProduct = new ArrayList<>();
        if ((listProduct.size() == 0 && (overwriteExistingProducts(fileName).length() == 0))) {
            listProduct.add("[\n");
        }
        String string = toJSON(product);
        if (listProduct == null) {
            listProduct.add(string + ",\n");
        } else {
            listProduct.add(string + "\n]");
        }
        fileWrite(listProduct ,fileName);

    }

    public void addProductInFile(List<Product> product, String fileName) throws IOException {
        for (int i = 0; i < product.size(); i++){
            addProductInFile(product.get(i), fileName);
        }
    }

    private void fileWrite(List<String> listProduct ,String fileName) throws IOException {
        String string = overwriteExistingProducts(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        if (string != null) {
            bufferedWriter.write(string);
        }
        for (int i = 0; i < listProduct.size(); i++) {
            bufferedWriter.append(listProduct.get(i));
        }
        bufferedWriter.close();
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

    public String toJSON(Product product){
        return "{\n\"type\":\""+ product.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1)+"\""+"," +
                "\n\"id\":" + product.getId() +
                ",\n\"name\":\"" + product.getName() + "\"" +
                ",\n\"price\":" + product.getPrice() + "\n}";
    }
}
