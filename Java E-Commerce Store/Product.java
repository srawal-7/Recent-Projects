abstract public class Product {
    public int id;
    private String name;
    private double price;

    //Setting constructor
    public Product (int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Get methods
    public String getProduct_name() {
        return name;
    }

    public double getProduct_price() {
        return price;
    }

    //Set methods
    public void setProduct_name(String name) {
        this.name = name;
    }

    public void setProduct_price(double price) {
        this.price = price;
    }

    //toString method
    public String toString() {
        return "Product name = " + name + ", price = " + price;
    }

    //Abstract methods for size and color from apparel and shoes classes
    public abstract String getSize();
    public abstract String getColor();

}
