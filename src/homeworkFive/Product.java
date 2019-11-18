package homeworkFive;

public abstract class Product {
    private String name;
    private int id;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Product product = (Product) obj;
        if (getId() != product.getId()) {
            return false;
        }
        if (!getName().equals(product.getName())){
            return false;
        }
        if (Double.compare(product.getPrice(), getPrice()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        long temp = Double.doubleToLongBits(getPrice());
        int result = 1;
        result = prime * result * getId() + (int) (temp ^ (temp >>> prime + 1));
        result = prime * result + getName().hashCode();
        return result;
    }
}
