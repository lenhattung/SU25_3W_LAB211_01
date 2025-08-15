package business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import models.Customer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tungi
 */
public class Customers extends HashSet<Customer> implements Workable<Customer>, Serializable {

    private String pathFile;
    private boolean saved;

    public Customers(String pathFile) {
        this.pathFile = pathFile;
        this.saved = true;
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

    public void show(Set<Customer> list) {
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

    public Set<Customer> filterByName(String name) {
        Set<Customer> result = new HashSet<Customer>();
        for (Customer c : this) {
            if (c.getName().contains(name)) {
                result.add(c);
            }
        }
        return result;
    }

    public boolean isSaved() {
        return saved;
    }

    public void saveToFile() {
        if (this.saved) {
            return;
        }
        try {
            // B1. Tao file moi
            File f = new File(pathFile);
            if (!f.exists()) {
                f.createNewFile();
            }

            // B2. Tao FileOutputStream
            FileOutputStream fos = new FileOutputStream(f);

            // B3. Tao ObjectOutputStream
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // B4. Ghi file
            oos.writeObject(this);

            // B5. Dong cac object
            oos.close();

            // B6. Thay doi trang thai cua saved
            this.saved = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
