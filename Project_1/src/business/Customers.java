package business;

import models.Customer;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tungi
 */
public class Customers extends ArrayList<Customer> implements Workable<Customer> {

    private String pathFile;
    private boolean saved;

    public Customers(String pathFile) {
        this.pathFile = pathFile;
    }

    public boolean isDuplicated(Customer c) {
        return this.contains(c);
    }

    @Override
    public void addNew(Customer t) {
        if (!this.isDuplicated(t)) {
            this.add(t);
            this.saved = false;
        } else {
            System.out.println("Error: Customer already exists!");
        }
    }

    @Override
    public void update(Customer t) {
        this.remove(t);
        this.add(t);
        this.saved = false;
    }

    @Override
    public Customer searchById(String id) {
        Customer result = null;
        for (Customer c : this) {
            if (c.getCustomerCode().equalsIgnoreCase(id)) {
                result = c;
            }
        }
        return result;
    }

    public void show(List<Customer> list) {
        System.out.println("-------------------------------------------------------------");
        System.out.format("%-6s | %-25s | %-11s | %-20s%n", "Code", "Customer Name", "Phone", "Email");
        System.out.println("-------------------------------------------------------------");
        for (Customer c : list) {
            System.out.format("%-6s | %-25s | %-11s | %-20s%n", c.getCustomerCode(), c.getName(), c.getPhoneNumber(), c.getEmail());
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public void showAll() {
        show(this);
    }

    public List<Customer> filterByName(String name) {
        List<Customer> result = new ArrayList<Customer>();
        for (Customer c : this) {
            if (c.getName().contains(name)) {
                result.add(c);
            }
        }
        return result;
    }

}
