package Model;

import java.util.List;

public class Rental {
    private String name;
    private String status;
    private List<Product> selectedProducts;
    private String noHp;
    private String alamat;

    public Rental(String name, Customer customer, List<Product> selectedProducts, String startDate, String endDate, String deliveryMethod, String paymentMethod, int rentalDuration, String noHp, String alamat) {
        this.name = name;
        this.selectedProducts = selectedProducts;
        this.status = "pending";
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void approve() {
        this.status = "approved";
    }

    public void reject() {
        this.status = "rejected";
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Rental status updated to: " + newStatus);
    }

    public void viewDetails() {
        System.out.println("Rental Name: " + name);
        System.out.println("Status: " + status);
        System.out.println("Selected Products:");
        for (Product product : selectedProducts) {
            System.out.println(" - " + product);
        }
    }

    @Override
    public String toString() {
        return "Rental Name: " + name + ", Status: " + status + ", Products: " + selectedProducts;
    }
}