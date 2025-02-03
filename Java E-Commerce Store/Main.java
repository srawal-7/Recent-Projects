//Name: Shriya Rawal
//Date: 12/04/2024

//Import statements
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Declaring ArrayList to store products and shopping cart items
        ArrayList<Product> product_list = new ArrayList<>();
        ArrayList<Product> shoppingCart = new ArrayList<>();

        //Declaring variables
        String addProducts = "";// Will be used to ask users if they want to add more products to their shopping cart
        String customer_info = ""; // Will be used to ask users if they want to provide us with more information
        int product_input = 0; //Will be used to store the product ID that users select to add to cart
        String customer_number = "Not provided"; //Used to check whether a valid input was provided for the phone number

        //Declaring a Scanner object to take customer input
        Scanner scan = new Scanner(System.in);

        //Creating 10 product objects
        Shoes shoe1 = new Shoes(1, "On Cloud", 140,"7.5","Blue");
        Shoes shoe2 = new Shoes(2, "Hoka", 120,"9.5","White");
        Shoes shoe3 = new Shoes(3, "Adidas", 109.10,"5.0","Purple");
        Shoes shoe4 = new Shoes(4, "On Cloud", 140,"9","Rosegold");
        Shoes shoe5 = new Shoes(5, "Hoka", 145,"5.5","Black & White");
        Apparel apparel1 = new Apparel(6, "Scarf", 45,"Medium","Black");
        Apparel apparel2 = new Apparel(7, "Old Navy Shirt", 25,"Extra-Large","Orange");
        Apparel apparel3 = new Apparel(8, "Kirkland socks", 7.99,"Small","Multi-color");
        Apparel apparel4 = new Apparel(9, "Scarf", 64.99,"Large","Metallic");
        Apparel apparel5 = new Apparel(10, "Hat", 29.99,"Small","Orange");

        //Adding above created 10 products into the product_list ArrayList
        product_list.add(shoe1);
        product_list.add(shoe2);
        product_list.add(shoe3);
        product_list.add(shoe4);
        product_list.add(shoe5);
        product_list.add(apparel1);
        product_list.add(apparel2);
        product_list.add(apparel3);
        product_list.add(apparel4);
        product_list.add(apparel5);

        //Asking to enter customer's name, it will ask if user wants to add information to save for future use
        System.out.println("Hello customer, please enter your name: ");
        String customer_name = scan.nextLine();
        System.out.println("Hi " + customer_name + "! Looks like you are a new customer. Would you like to provide additional information to save for future transactions? (Yes/No)");
        customer_info = scan.nextLine();

        //Create a new customer object with just their name
        Customer customer = new Customer(customer_name);

        //Conditional for when the user agrees to give email and phone information
        if (customer_info.equalsIgnoreCase("Yes")) { //If Customer says Yes to adding more information
            System.out.println("Please enter your email: ");
            customer.setCustomer_email(scan.nextLine());
            //while loop within in case the user provides input that is not a number like dash in between numbers or parenthesis
            //Also catching InputMisMatchException within the loop to catch invalid input effectively
            while (customer_number.equals("Not provided")) {
                try {
                    System.out.println("Please enter your phone number (ex. 1234567890): ");
                    customer.setCustomer_phone(scan.nextLong());
                    customer_number = "Provided";
                    scan.nextLine();
                } catch (InputMismatchException exception1) {
                    System.out.println("Error: Please enter a number!");
                    scan.nextLine();
                }
            } //This output will be displayed at the end along with the final purchase as the "receipt"
        } else {
            System.out.println("Okay, no problem! Your information will not be saved into our system and you will use our guest checkout.");
        }

        //Adding a few print statements that will display the list of products at this e-store
        System.out.println("Welcome to our mini E-Store! Here is our list of current products for you to view: ");
        System.out.println(); //for extra space
        System.out.printf("%1s %19s %9s %9s %10s\n", "ID", "Product", "Price", "Size", "Color"); //trying to add a table like structure

        //for loop to display all products along with their id, name, price, size and color from the product_list ArrayList
        for (int i = 0; i < product_list.size(); i++) {
            Product product = product_list.get(i);
            System.out.printf("%1d %20s %9.2f %10s %10s\n", (i + 1), product.getProduct_name(), product.getProduct_price(), product.getSize(), product.getColor());
        }

        //adding two additional product value and displaying outside the loop because they don't actually exist in my product list
        //and are actually out of stock
        System.out.printf("%1d %20s %9.2f %10s %10s\n", 11, "Bracelet", 18.00, "Kids", "Rainbow"); //This is the additional product that is not in my ArrayList and will be shown as out of stock
        System.out.printf("%1d %20s %9.2f %10s %10s\n", 12, "Athletic shorts", 12.99, "Small", "Orange"); //This is the additional product that is not in my ArrayList and will be shown as out of stock
        System.out.println(); //for extra space

        //Scanner statement to get user input for which products they would like to add to cart
        System.out.println("please enter the Product ID that you would like to add to your cart: ");
        product_input = scan.nextInt();
        scan.nextLine(); //for any buffer space that might get missed

        //Need to compare the product id that the user enters to the product id that is in my program
        //Adding a custom exception that would trigger when products 11 & 12 are selected - as they are not in my arraylist and are hence out of stock
        //Adding everything within a do-while loop, because I would like for the program to display the product information once before starting to interact with the user
        do {
            try {
                if (product_input == shoe1.id)
                    shoppingCart.add(shoe1);
                else if (product_input == shoe2.id)
                    shoppingCart.add(shoe2);
                else if (product_input == shoe3.id)
                    shoppingCart.add(shoe3);
                else if (product_input == shoe4.id)
                    shoppingCart.add(shoe4);
                else if (product_input == shoe5.id)
                    shoppingCart.add(shoe5);
                else if (product_input == apparel1.id)
                    shoppingCart.add(apparel1);
                else if (product_input == apparel2.id)
                    shoppingCart.add(apparel2);
                else if (product_input == apparel3.id)
                    shoppingCart.add(apparel3);
                else if (product_input == apparel4.id)
                    shoppingCart.add(apparel4);
                else if (product_input == apparel5.id)
                    shoppingCart.add(apparel5);
                else
                    throw new OutofStock("We apologize, this product is currently out of stock!");
            } catch (OutofStock exception2) {
                System.out.println("Error: " + exception2.getMessage());
            }
            //Scanner asking whether the user would like to add more products to cart
            System.out.println("Would you like to add more products? (Yes/No) "); //Please enter either Yes or No
            addProducts = scan.nextLine();

            //Conditional for whether the user says yes or no for additional products
            if (addProducts.equalsIgnoreCase("Yes")) {
                System.out.println("Please enter the Product ID that you would like to add to your cart: ");
                product_input = scan.nextInt();
                scan.nextLine();
            } else if (addProducts.equalsIgnoreCase("No")) {
                System.out.println("Okay! No more products will be added");
            }
        } while (addProducts.equalsIgnoreCase("Yes"));

        //Displaying the product information for the items added to the shoppingCart
        System.out.println("Following are the items in your Shopping Cart: ");
        for (Product product : shoppingCart) {
            System.out.println(product);
        }

        //Code to calculate the total price from the shopping cart
        double sum = 0.0;
        Order order = new Order(1, sum);
        for (Product product : shoppingCart) {
            sum += product.getProduct_price();  //Add product price to total
        }
        order.setOrder_total(sum);

        System.out.println(); //Adding extra space
        System.out.println("Proceeding to Checkout! ");
        System.out.println("RECEIPT");
        System.out.println(); //Adding extra space

        //Conditional for customer name, phone and email based off the user's answer on whether they would like to provide more information
        //If yes, then showing the user input but if not, then a basic value of Guest for the name and 0 for the rest is displayed
        //***********************************
        System.out.println("Name: " + (customer_info.equalsIgnoreCase("Yes") ? customer_name : "Guest"));
        System.out.println("Phone: " + (customer.getCustomer_phone() != null ? customer.getCustomer_phone() : 0));
        System.out.println("Email: " + (customer.getCustomer_email() != null ? customer.getCustomer_email() : "0"));
        //***********************************

        System.out.println("Total Price: " + order.getOrder_total());
        System.out.println(); //Adding extra space
        System.out.println("Thank you for shopping with us!");
    }}
