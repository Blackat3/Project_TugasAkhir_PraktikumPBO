package View;

public class RentalView {
    public void displayMainMenu() {
        System.out.println("=== Main Menu ===");
        System.out.println("Login as: (1.) Admin");
        System.out.println(" (2.) Customer");
        System.out.println(" (3.) Exit");
    }

    public void displayAdminMenu() {
        System.out.println("=== Admin Menu ===");
        System.out.println("1. Add Product");
        System.out.println("2. Edit Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Manage Item Status");
        System.out.println("5. Approve Rental");
        System.out.println("6. Reject Rental");
        System.out.println("7. View Rental Details");
        System.out.println("8. View Product List");
        System.out.println("9. Logout");
    }

    public void displayCustomerMenu() {
        System.out.println("1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Create Rental");
        System.out.println("5. Return Rental");
        System.out.println("6. Logout");
    }
}