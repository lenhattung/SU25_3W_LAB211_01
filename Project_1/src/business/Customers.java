package business;


import models.Customer;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tungi
 */
public class Customers extends ArrayList<Customer> implements Workable<Customer>{

    @Override
    public void addNew(Customer t) {
    }

    @Override
    public void update(Customer t) {
    }

    @Override
    public Customer search(String s) {
        return null;
    }

    @Override
    public void showAll() {
    }
    
}
