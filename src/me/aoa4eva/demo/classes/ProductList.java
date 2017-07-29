package me.aoa4eva.demo.classes;

import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> p;


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
