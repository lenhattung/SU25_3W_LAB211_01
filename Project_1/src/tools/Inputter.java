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

    public String input(String message, String errorMsg, String regex) {
        String result;
        boolean reInput = false;
        do {
            System.out.println(message);
            result = scanner.nextLine();
            reInput = !Acceptable.isValid(result, regex);
            if (reInput) {
                System.out.println(errorMsg + ". Plese re-enter ... ");
            }
        } while (reInput);
        return result;
    }

    public Customer inputCustomer() {
        Customer customer = new Customer();
        
        // Input customerCode
        String message = "Enter Customer code\n (A unique 5-character string. The first character is \"C\", \"G\"or \"K\", followed by 4 digits.)";
        String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
        String regex = Acceptable.customerCodeRegex;
        customer.setCustomerCode(input(message, errorMsg, regex));

        // Input name
        message = "Input name (A non-empty string between 2 and 25 characters long): ";
        errorMsg = "Error: Name cannot be empty. Name must be between 2 and 25 characters.";
        regex = Acceptable.nameRegex;
        customer.setName(input(message, errorMsg, regex));

        // Input phone
        message = "A 10-digit number belonging to a network operator in Vietnam.";
        errorMsg = "Error: Invalid phone format!";
        regex = Acceptable.phoneRegex;
        customer.setPhoneNumber(input(message, errorMsg, regex));

        // Input email
        message = "Input email: ";
        errorMsg = "Error: Invalid email format!";
        regex = Acceptable.emailRegex;
        customer.setEmail(input(message, errorMsg, regex));

        return customer;
    }

    public static void main(String[] args) {
        Inputter inputter = new Inputter();
        Customer c = inputter.inputCustomer();
        System.out.println(c);
    }

}
