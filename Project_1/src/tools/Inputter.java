/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;
import models.Customer;

/**
 *
 * @author tungi
 */
public class Inputter {

    private Scanner scanner;

    public Inputter() {
        scanner = new Scanner(System.in);
    }

    public Customer inputCustomer() {
        Customer customer = new Customer();
        // input customerCode
        String customerCode = "";
        String customerCodeRegex = "^[CGKcgk]\\d{4}$";
        do {
            System.out.println("Enter Customer code\n (A unique 5-character string. The first character is \"C\", \"G\"or \"K\", followed by 4 digits.)");
            customerCode = scanner.nextLine();
            if (!customerCode.matches(customerCodeRegex)) {
                System.err.println("Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!");
            }
        } while (!customerCode.matches(customerCodeRegex));

        // input name
        String name = "";
        String nameRegex = "^.{2,25}$";
        do {
            System.out.println("Input name (A non-empty string between 2 and 25 characters long): ");
            name = scanner.nextLine();
            if (!name.matches(nameRegex)) {
                System.err.println("Error: Name cannot be empty. Name must be between 2 and 25 characters.");
            }
        } while (!name.matches(nameRegex));
        
        // input name
        String phone = "";
        String phoneRegex = "^.{2,25}$";
        do {
            System.out.println("A 10-digit number belonging to a network operator in Vietnam.");
            name = scanner.nextLine();
            if (!name.matches(nameRegex)) {
                System.err.println("Error: Name cannot be empty. Name must be between 2 and 25 characters.");
            }
        } while (!name.matches(nameRegex));

        return customer;
    }

    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        inputter.inputCustomer();
    }

}
