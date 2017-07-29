package me.aoa4eva.demo.classes;

public class Product {
	/**
	 * This is a class to hold details about a single product
	 * */
    private double price;
    private String description;
    /**
     * Getters and setters are used to change values of the private variables
     * declared in the class*/
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", description='" + description + '\'' +
                '}';
    }


}
