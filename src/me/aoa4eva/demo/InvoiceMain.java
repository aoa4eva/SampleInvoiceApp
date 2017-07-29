package me.aoa4eva.demo;
import me.aoa4eva.demo.classes.Product;

import java.util.ArrayList;
import java.util.Scanner;
/*This is a sample invoice application */
public class InvoiceMain {

    public static void main(String[] args) {

        double productPrice;
        String productDesc;
        double taxRate;
        double totalAmount=0;
        double productTotal=0;

        double taxCharged;
        String response="y";
        ArrayList<Product> pList;

        Scanner sc = new Scanner(System.in);

        pList = new ArrayList <Product>();

        System.out.println("Enter tax rate");
        while(!sc.hasNextDouble())
        {
            System.out.println("Invalid number. Please enter a tax rate e.g. '3'");
            sc.next();

        }
        taxRate = sc.nextDouble();
        sc.nextLine();

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

        for(Product aNewProduct : pList)
        {
            System.out.println(aNewProduct.toString());
            productTotal+=aNewProduct.getPrice();
        }
        taxCharged = (taxRate/100) * productTotal;

        System.out.println("The pre-tax total is:"+totalAmount);
        System.out.println("The tax due is:"+taxCharged);
        totalAmount=productTotal+taxCharged;
        System.out.println("The Grand Total is:"+totalAmount);

        //Format to two decimal places

        //Display a table (courtesy http://bit.ly/2uIAkNb)
        String leftAlignFormat = "| %-35s | %-10.2f |%n";

        System.out.format("+-------------------------------------+------------+%n");
        System.out.format("| Description                         | Price      |%n");
        System.out.format("+-------------------------------------+------------+%n");
        for(Product aNewProduct : pList)
        {
            //System.out.format(leftAlignFormat, "some data" + i, i * i);
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
