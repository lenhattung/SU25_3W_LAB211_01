package business;

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
        if(isDupplicated(t)){
            System.out.println("Dupplicate data!");
        }else{
            this.add(t);
            this.saved=false;
        }
    }

    @Override
    public void update(Order t) {
        this.remove(t);
        this.add(t);
        this.saved=false;
    }

    @Override
    public Order searchById(String s) {
        for (Order o : this) {
            if (o.getOrderId().equals(s)){
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
                    && o.getEventDate().equals(order.getEventDate())) 
            {
                return true;
            }
        }
        return false;
    }
}
