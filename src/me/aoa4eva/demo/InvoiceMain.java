package me.aoa4eva.demo;
import me.aoa4eva.demo.classes.Product;

import java.util.ArrayList;
import java.util.Scanner;
/** This is a sample invoice application 
 * @author aoa4eva
 * */
public class InvoiceMain {

    public static void main(String[] args) {
    	/** Variables to be used in the application*/
        double productPrice;
        String productDesc;
        double taxRate;
        double totalAmount=0;
        double productTotal=0;

        double taxCharged;
        String response="y";
        
        //The 'shopping list' 
        ArrayList<Product> pList=new ArrayList <Product>();
        
        //Created to accept user input 
        Scanner sc = new Scanner(System.in);
        
        //Prompt user for tax rate 
        System.out.println("Enter tax rate");
        //use .hasNext for data types to validate for each type 
        while(!sc.hasNextDouble())
        {
            System.out.println("Invalid number. Please enter a tax rate e.g. '3'");
            sc.next();

        }
        taxRate = sc.nextDouble();
        //Use this to capture the return (enter) key, so that the app does not skip to the next line
        sc.nextLine();

        //Check to see if the user would like to enter another product
        do{
            if(!response.equalsIgnoreCase("y"))
            {
                System.out.println("You must enter either 'Y' or 'N'");
            }
            else{
                System.out.println("Enter product price");
                while(!sc.hasNextDouble())
                {
                    System.out.println("Invalid number. Please product price");
                    sc.next();

                }
                productPrice = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter product description");
                while(!sc.hasNextLine())
                {
                    System.out.println("You must enter a product description");
                    sc.next();

                }
                productDesc = sc.nextLine();
                System.out.println("The product price is "+productPrice+" and the description is "+productDesc);
                Product p = new Product();
                p.setDescription(productDesc);
                p.setPrice(productPrice);
                pList.add(p);

            }
            System.out.println("Would you like to enter more product details? ");
            response = sc.nextLine();
        }while(!response.equalsIgnoreCase("n"));
        
        //Iterate through the 'shopping list' 
        for(Product aNewProduct : pList)
        {
            //Use the toString() method to show what the product item contains
        	System.out.println(aNewProduct.toString());
            productTotal+=aNewProduct.getPrice();
        }
        taxCharged = (taxRate/100) * productTotal;
        
        //Show the pre-tax total, tax charged and total amount in plain text
        System.out.println("The pre-tax total is:"+totalAmount);
        System.out.println("The tax due is:"+taxCharged);
        totalAmount=productTotal+taxCharged;
        System.out.println("The Grand Total is:"+totalAmount);

        //Format to two decimal places

        //Display a table (courtesy http://bit.ly/2uIAkNb)
        /*Format the body of the table to have a | character, followed by 
         * 35 string characters
         * and another | followed by a float, made up of 10 digits for the number
         * and 2 digits for the decimal place
         * Move to the net line (%n)
         */
        String leftAlignFormat = "| %-35s | %-10.2f |%n";
        

        System.out.format("+-------------------------------------+------------+%n");
        System.out.format("| Description                         | Price      |%n");
        System.out.format("+-------------------------------------+------------+%n");
        for(Product aNewProduct : pList)
        {
        	/*Format the string using the product description as the string, and the product price
        	as the float to display
        	*/
            System.out.format(leftAlignFormat,aNewProduct.getDescription(),aNewProduct.getPrice());
        }
        System.out.format("+-------------------------------------+------------+%n");
        System.out.format(leftAlignFormat,"Sub Total",productTotal);
        System.out.format(leftAlignFormat,"Tax Amount",taxCharged);
        System.out.format("+-------------------------------------+------------+%n");
        System.out.format(leftAlignFormat,"Grand Total",totalAmount);
        System.out.format("+-------------------------------------+------------+%n");

    }
}
