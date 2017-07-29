package me.aoa4eva.demo.classes;

import java.util.ArrayList;

public class ProductList {

	private ArrayList<Product> p;
    /**
     * This is a class that functions as a 'shopping cart', holding products
     * before an invoice is generated. It contains an arraylist of products 
     * which is instantiated when an object of the ProductList class is created.
     * It also has a method called add so that individual product items can be
     * added to the list.
     * The getter method returns an entire object with all of the contents of the
     * arraylist. 
     * The setter method stores an entire object with all of the contents of the 
     * arraylist. 
     * */

    public ProductList()
    {
        p = new ArrayList<Product>();
    }

    public ArrayList<Product> getP() {
        return p;
    }

    public void setP(ArrayList<Product> p) {
        this.p = p;
    }

    public void addProduct(Product aProduct){
        p.add(aProduct);
    }


}
