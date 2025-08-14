/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import business.Customers;
import business.Orders;
import business.SetMenus;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import models.Customer;
import models.Order;
import models.SetMenu;

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

    public Customer inputCustomer(boolean isUpdated) {
        Customer customer = new Customer();

        // Input customerCode
        String message = "Enter Customer code\n (A unique 5-character string. The first character is \"C\", \"G\"or \"K\", followed by 4 digits.)";
        String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
        String regex = Acceptable.customerCodeRegex;
        if (!isUpdated) {
            customer.setCustomerCode(input(message, errorMsg, regex));
        }
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

    public Order inputOrder(Customers customers, SetMenus setMenus, Orders orders) {
        // Input customerCode
        String customerCode = "";
        boolean reInput = false;
        do {
            String message = "Enter Customer code\n (A unique 5-character string. The first character is \"C\", \"G\"or \"K\", followed by 4 digits.)";
            String errorMsg = "Customer code cannot be empty! Customer code must start with C, G, K, followed by 4 digits!";
            String regex = Acceptable.customerCodeRegex;
            customerCode = input(message, errorMsg, regex);
            reInput = (customers.searchById(customerCode) == null);
            if (reInput) {
                System.out.println("Customer is not in the list of Customers. Please re input!");
            }
        } while (reInput);

        // Input SetMenu
        String setMenuId = "";
        SetMenu setMenu = null;
        reInput = false;
        do {
            String message = "Enter SetMenu Id";
            String errorMsg = "SetMenu is invalid!";
            String regex = Acceptable.anything;
            setMenuId = input(message, errorMsg, regex);
            setMenu = setMenus.searchById(setMenuId);
            reInput = (setMenu == null);
            if (reInput) {
                System.out.println("SetMenu is not in the list of SetMenus. Please re input!");
            }
        } while (reInput);

        // ---- 
        int numberOfTables = 0;
        String msg = "Enter number of tables:";
        String errorMsg = "Number of tables must be greater than zero!";
        String regex = Acceptable.positive_integer;
        numberOfTables = Integer.parseInt(input(msg, errorMsg, regex).toUpperCase());

        
         // ---
        Date eventDate = null;
        boolean checkEventDate = false;
        do {
            try {
                System.out.println("Enter preferred event date:");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String inputDate = scanner.nextLine().trim();
                eventDate = sdf.parse(inputDate);
                Date today = new Date();
                if (eventDate.after(today)) {
                    checkEventDate = true;
                } else {
                    System.out.println("Error: Event date must be in the future.");
                }
            } catch (Exception e) {
            }
        } while (!checkEventDate);
        
        // Tao don hang moi
        Order order = new Order(generateOrderId(), customerCode, setMenuId, numberOfTables, eventDate);
        
        return order;
    }
    
    public String generateOrderId(){
        Date date = new Date();
        //return ""+(date.getYear()+1900)+(date.getMonth()+1)+(date.getDate())+(date.getHours())+(date.getMinutes())+(date.getSeconds());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }

}
