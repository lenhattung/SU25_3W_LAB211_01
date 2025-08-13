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
public class Orders extends ArrayList<Order> implements Workable<Order>{

    @Override
    public void addNew(Order t) {
    }

    @Override
    public void update(Order t) {
    }

    @Override
    public Order search(String s) {
        return null;
    }

    @Override
    public void showAll() {
    }
    
}
