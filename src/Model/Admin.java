package Model;
import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, String noHp, String alamat) {
        super(username, password, noHp, alamat);
    }

    @Override
    public boolean login(String username, String password) {
        return this.getUsername().equals(username) && this.password.equals(password);
    }


    public static void addProduct(List<Product> productList, Product product) {
        productList.add(product);
        System.out.println("Product added: " + product.getName());
    }

    public void editProduct(Product product, String newName, String newBrand, String newType, double newPrice, String newDescription, int newStock) {
        product.setName(newName);
        product.setBrand(newBrand);
        product.setType(newType);
        product.setPrice(newPrice);
        product.setDescription(newDescription);
        product.setStock(newStock);
        System.out.println("Product edited: " + product.getName());
    }

    public void deleteProduct(List<Product> productList, Product product) {
        productList.remove(product);
        System.out.println("Product deleted: " + product.getName());
    }

    public void manageItemStatus(Product product, String newStatus) {
        product.setStatus(newStatus);
        System.out.println("Product status updated: " + product.getName() + " is now " + newStatus);
    }

    public void approveRental(Rental rental) {
        rental.updateStatus("Approved");
        System.out.println("Rental approved: " + rental.getName());
    }

    public void rejectRental(Rental rental) {
        rental.updateStatus("Rejected");
        System.out.println("Rental rejected: " + rental.getName());
    }

    public void viewRentalDetails(Rental rental) {
        System.out.println("Rental Details:");
        rental.viewDetails();
    }
}