package Controller;

import Model.Admin;
import Model.Customer;
import Model.Product;
import Model.Rental;
import java.util.ArrayList;
import java.util.List;

public class RentalController {
    private Admin admin;
    private List<Customer> customers;
    private List<Product> productList;
    private List<Rental> rentalList;

    public RentalController() {
        this.productList = new ArrayList<>();
        this.rentalList = new ArrayList<>();
        this.admin = new Admin("admin", "adminpass", "123456789", "Admin Address");
        this.customers = new ArrayList<>();
        this.customers.add(new Customer("customer", "custpass", "987654321", "Customer Address")); // Add a default customer
    }

    public Admin getAdmin() {
        return admin;
    }

    public Customer getCustomer() {
        return customers.get(0);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void registerCustomer(String username, String password, String noHp, String alamat) {
        Customer newCustomer = new Customer(username, password, noHp, alamat);
        customers.add(newCustomer);
        System.out.println("Customer registered: " + username);
    }
}