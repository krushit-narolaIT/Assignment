package com.narola.krushit;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(int productID, String productName, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}

public class ProductFunctionalDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 67000.00, 10));
        products.add(new Product(2, "Table", 800.00, 0));
        products.add(new Product(3, "Globe", 1500.00, 20));
        products.add(new Product(4, "TV", 50000.00, 5));

        Predicate<Product> isAvailable = product -> product.getProductQuantity() > 0;
        Predicate<Product> isExpensive = product -> product.getProductPrice() > 49000;
        System.out.println("Available Products:");
        for(Product product : products){
            if(isAvailable.test(product)){
                System.out.println(product);
            }
        }

        System.out.println("Expensive Product");
        for(Product product : products){
            if(isExpensive.test(product)){
                System.out.println(product);
            }
        }

        Function<Product, Product> applyDiscount = product -> {
            if(isExpensive.test(product)){
                product.setProductPrice(product.getProductPrice() * 0.5);
            } else {
                product.setProductPrice(product.getProductPrice() * 0.9);
            }
            return product;
        };

        System.out.println("\nProducts On Sale:");
        for(Product product : products){
            System.out.println("-> " + applyDiscount.apply(product));
        }

        Consumer<Product> displayProduct = product -> System.out.println("Product Details: " + product);
        System.out.println("\nDisplaying Products:");
        products.forEach(displayProduct);

        Supplier<Product> defaultProductSupplier = () -> new Product(0, "No Products", 0.0, 0);
        if (products.isEmpty()) {
            Product defaultProduct = defaultProductSupplier.get();
            System.out.println("\nDefault Product: " + defaultProduct);
        }
    }
}
