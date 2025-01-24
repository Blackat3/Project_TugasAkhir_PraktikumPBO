package Aplication;
import java.util.InputMismatchException;
import Controller.RentalController;
import Model.*;
import View.RentalView;
import java.util.Optional;
import java.util.Scanner;

public class RentalManagementMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalController controller = new RentalController();
        RentalView view = new RentalView();
        Customer activeCustomer = null;

        while (true) {
            try {
                view.displayMainMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    Admin admin = controller.getAdmin();
                    if (admin.login(username, password)) {
                        System.out.println("Admin logged in successfully!");

                        while (true) {
                            view.displayAdminMenu();
                            int adminChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (adminChoice == 1) {
                                System.out.print("Enter name: ");
                                String name = scanner.nextLine();
                                System.out.print("Enter brand: ");
                                String brand = scanner.nextLine();
                                System.out.print("Enter type: ");
                                String type = scanner.nextLine();
                                System.out.print("Enter price: ");
                                double price = scanner.nextDouble();
                                System.out.print("Enter stock: ");
                                int stock = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter description: ");
                                String description = scanner.nextLine();

                                Product product = new Product(name, brand, type, price, description, stock, "Available");
                                admin.addProduct(controller.getProductList(), product);
                                System.out.println("Product added successfully!");
                            } else if (adminChoice == 2) {
                                System.out.print("Enter product name to edit: ");
                                String name = scanner.nextLine();
                                Optional<Product> productOpt = controller.getProductList().stream()
                                        .filter(p -> p.getName().equalsIgnoreCase(name))
                                        .findFirst();

                                if (productOpt.isPresent()) {
                                    Product product = productOpt.get();
                                    System.out.print("Enter new name: ");
                                    product.setName(scanner.nextLine());
                                    System.out.print("Enter new brand: ");
                                    product.setBrand(scanner.nextLine());
                                    System.out.print("Enter new type: ");
                                    product.setType(scanner.nextLine());
                                    System.out.print("Enter new price: ");
                                    product.setPrice(scanner.nextDouble());
                                    System.out.print("Enter new stock: ");
                                    product.setStock(scanner.nextInt());
                                    scanner.nextLine();
                                    System.out.print("Enter new description: ");
                                    product.setDescription(scanner.nextLine());
                                    System.out.println("Product updated successfully!");
                                } else {
                                    System.out.println("Product not found!");
                                }
                            } else if (adminChoice == 3) {
                                System.out.print("Enter product name to delete: ");
                                String name = scanner.nextLine();
                                boolean removed = controller.getProductList().removeIf(p -> p.getName().equalsIgnoreCase(name));
                                if (removed) {
                                    System.out.println("Product deleted successfully!");
                                } else {
                                    System.out.println("Product not found!");
                                }
                            } else if (adminChoice == 4) {
                                System.out.print("Enter product name to manage status: ");
                                String name = scanner.nextLine();
                                try {
                                    Optional<Product> productOpt = controller.getProductList().stream()
                                            .filter(p -> p.getName().equalsIgnoreCase(name))
                                            .findFirst();

                                    if (productOpt.isPresent()) {
                                        Product product = productOpt.get();
                                        System.out.print("Enter new status (Available, In Maintenance, Unavailable): ");
                                        String newStatus = scanner.nextLine();
                                        admin.manageItemStatus(product, newStatus);
                                        System.out.println("Item status updated successfully!");
                                    } else {
                                        System.out.println("Product not found!");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (adminChoice == 5) {
                                System.out.println("Available Rentals:");
                                for (Rental rental : controller.getRentalList()) {
                                    System.out.println(rental);
                                }

                                System.out.print("Enter rental name to approve: ");
                                String name = scanner.nextLine();
                                Optional<Rental> rentalOpt = controller.getRentalList().stream()
                                        .filter(r -> name.equalsIgnoreCase(r.getName()))
                                        .findFirst();

                                if (rentalOpt.isPresent()) {
                                    Rental rental = rentalOpt.get();

                                    if (activeCustomer != null) {
                                        RentalService rentalService = new RentalService(activeCustomer.getKeranjang());
                                        rentalService.approve(rental);
                                    } else {
                                        System.out.println("Active customer is not initialized. Please log in as a customer first.");
                                    }
                                } else {
                                    System.out.println("Rental not found! Please check the rental name.");
                                }
                            } else if (adminChoice == 6) {
                                System.out.println("Available Rentals:");
                                for (Rental rental : controller.getRentalList()) {
                                    System.out.println(rental);
                                }

                                System.out.print("Enter rental name to reject: ");
                                String name = scanner.nextLine();
                                Optional<Rental> rentalOpt = controller.getRentalList().stream()
                                        .filter(r -> name.equalsIgnoreCase(r.getName()))
                                        .findFirst();

                                if (rentalOpt.isPresent()) {
                                    Rental rental = rentalOpt.get();

                                    if (activeCustomer != null) {
                                        RentalService rentalService = new RentalService(activeCustomer.getKeranjang());
                                        rentalService.reject(rental);
                                    } else {
                                        System.out.println("Active customer is not initialized. Please log in as a customer first.");
                                    }
                                } else {
                                    System.out.println("Rental not found! Please check the rental name.");
                                }
                            } else if (adminChoice == 7) {
                                System.out.println("Available Rentals:");
                                for (Rental rental : controller.getRentalList()) {
                                    System.out.println(rental);
                                }

                                System.out.print("Enter rental name to view details: ");
                                String name = scanner.nextLine();
                                Optional<Rental> rentalOpt = controller.getRentalList().stream()
                                        .filter(r -> name.equalsIgnoreCase(r.getName()))
                                        .findFirst();

                                if (rentalOpt.isPresent()) {
                                    Rental rental = rentalOpt.get();
                                    rental.viewDetails();
                                } else {
                                    System.out.println("Rental not found! Please check the rental name.");
                                }
                            } else if (adminChoice == 8) {
                                System.out.println("Product List:");
                                if (controller.getProductList().isEmpty()) {
                                    System.out.println("No products available.");
                                } else {
                                    for (Product product : controller.getProductList()) {
                                        System.out.println(product);
                                    }
                                }
                            } else if (adminChoice == 9) {
                                System.out.println("Logged out.");
                                break;
                            } else {
                                System.out.println("Invalid option. Try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid admin credentials!");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    Customer customer = controller.getCustomer();
                    if (!customer.login(username, password)) {
                        System.out.println("Invalid customer credentials!");
                    } else {
                        activeCustomer = customer;
                        System.out.println("Customer logged in successfully!");

                        while (true) {
                            view.displayCustomerMenu();
                            int customerChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (customerChoice == 1) {
                                System.out.println("Product List:");
                                if (controller.getProductList().isEmpty()) {
                                    System.out.println("No products available.");
                                } else {
                                    for (Product product : controller.getProductList()) {
                                        System.out.println(product);
                                    }
                                }
                            } else if (customerChoice == 2) {
                                System.out.print("Enter product name to add to cart: ");
                                String name = scanner.nextLine();
                                Optional<Product> productOpt = controller.getProductList().stream()
                                        .filter(p -> p.getName().equalsIgnoreCase(name))
                                        .findFirst();

                                if (productOpt.isPresent()) {
                                    customer.getKeranjang().addItem(productOpt.get());
                                    System.out.println("Product added to cart.");
                                } else {
                                    System.out.println("Product not found!");
                                }
                            } else if (customerChoice == 3) {
                                customer.getKeranjang().viewKeranjang();
                            } else if (customerChoice == 4) {
                                System.out.print("Enter product name to rent: ");
                                String productName = scanner.nextLine();
                                System.out.print("Enter start date: ");
                                String startDate = scanner.nextLine();
                                System.out.print("Enter end date: ");
                                String endDate = scanner.nextLine();
                                System.out.print("Enter delivery method: ");
                                String deliveryMethod = scanner.nextLine();
                                System.out.print("Enter payment method: ");
                                String paymentMethod = scanner.nextLine();
                                System.out.print("Enter rental duration (in days): ");
                                int rentalDuration = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter your phone number: ");
                                String noHp = scanner.nextLine();
                                System.out.print("Enter your address: ");
                                String alamat = scanner.nextLine();

                                if (activeCustomer != null) {
                                    if (activeCustomer.requestRentalByName(controller, productName, startDate, endDate, deliveryMethod, paymentMethod, rentalDuration, noHp, alamat)) {
                                        System.out.println("Rental request submitted successfully. Awaiting admin approval.");
                                    } else {
                                        System.out.println("Rental request failed. Please check your cart.");
                                    }
                                } else {
                                    System.out.println("Active customer is not initialized. Please log in as a customer first.");
                                }
                            } else if (customerChoice == 5) {
                                System.out.print("Enter rental name to return: ");
                                String rentalName = scanner.nextLine();
                                System.out.print("Enter number of days late: ");
                                int daysLate = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    if (activeCustomer != null) {
                                        activeCustomer.returnRental(controller, rentalName, daysLate);
                                    } else {
                                        System.out.println("Active customer is not initialized. Please log in as a customer first.");
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } else if (customerChoice == 6) {
                                System.out.println("Logged out.");
                                break;
                            } else {
                                System.out.println("Invalid option. Try again.");
                            }
                        }
                    }
                } else if (choice == 3) {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String noHp = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String alamat = scanner.nextLine();

                    controller.registerCustomer(username, password, noHp, alamat);
                } else if (choice == 4) {
                    System.out.println("Exiting program. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}