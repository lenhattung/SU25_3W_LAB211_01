package business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import models.Order;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tungi
 */
public class Orders extends ArrayList<Order> implements Workable<Order> {

    private String pathFile;
    private boolean saved;

    public Orders(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void addNew(Order t) {
        if (isDupplicated(t)) {
            System.out.println("Dupplicate data!");
        } else {
            this.add(t);
            this.saved = false;
        }
    }

    @Override
    public void update(Order t) {
        this.remove(t);
        this.add(t);
        this.saved = false;
    }

    @Override
    public Order searchById(String s) {
        for (Order o : this) {
            if (o.getOrderId().equals(s)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void showAll() {
    }

    public boolean isDupplicated(Order order) {
        for (Order o : this) {
            if (o.getCustomerCode().equals(order.getCustomerCode())
                    && o.getMenuId().equals(order.getMenuId())
                    && o.getEventDate().equals(order.getEventDate())) {
                return true;
            }
        }
        return false;
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
