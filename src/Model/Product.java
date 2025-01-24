package Model;

public class Product {
    private String name;
    private String brand;
    private String type;
    private double price;
    private String description;
    private int stock;
    private String status;

    public Product(String name, String brand, String type, double price, String description, int stock, String status) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Brand: " + brand +
                ", Type: " + type + ", Price: " + price + ", Stock: " + stock +
                ", Description: " + description + ", Status: " + status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
