import Entity.Customer;
import Entity.Order;
import Entity.Product;
import Entity.ShoppingCart;
import ExceptionPkg.InvalidOrderException;
import ExceptionPkg.OrderNotFoundException;
import ExceptionPkg.StockUnavailableException;

import java.util.HashSet;
import java.util.Set;

/**
 * ShopNow : Entry point of application
 *
 * @author Krushit Babariya
 * @version 1.0
 */
public class ShopNow {
    public static void main(String[] args) {
        //Keep Track of Product Items
        Set<Product> productSet = new HashSet<>();

        //Keep Track of User Items
        Set<Customer> customerSet = new HashSet<>();

        //Keep track of all Orders in shopNow
        Set<Order> ordersSet = new HashSet<>();

        Product product1 = new Product(1, "T-shirt", 230.25, 5);
        //P2 is duplicate so it can not add into Set
        Product product2 = new Product(1, "T-shirt", 230.25, 5);
        Product product3 = new Product(2, "T-shirt", 230.25, 5);

        //Add products to product list
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        //Print Products Available on shopNow portal
        System.out.println(productSet);

        // Register Customer in ShowNow Application

        Customer customer1 = new Customer(1, "Krushit", "ksb@narola.email", "9874563214");
        //Customer Already Registered so it can not register again
        Customer customer2 = new Customer(1, "Krushit", "ksb@narola.email", "9874563214");
        //Customer with same name, phone, email can not register again bcz no person have same id and mobile number
        Customer customer3 = new Customer(2, "Krushit", "ksb@narola.email", "9874563214");
        Customer customer4 = new Customer(3, "Sujal", "ssb@gmail.com", "9874563214");

        customerSet.add(customer1);
        customerSet.add(customer2);
        customerSet.add(customer3);
        customerSet.add(customer4);

        //Print all registered customers on shopNow portal
        System.out.println(customerSet);

        //Place Order
        Order order1 = null;
        Order order2 = null;
        Order order3 = null;
        try {
            order1 = new Order(1, customer1, product1, 3);
            order2 = new Order(2, customer1, product1, 1);
            //second order gives insufficient stock exception
            order3 = new Order(3, customer4, product3, 8);
        } catch (InvalidOrderException e) {
            e.printStackTrace();
        } catch (StockUnavailableException e) {
            e.printStackTrace();
        }

        //Create Cart for customer
        ShoppingCart cart1 = new ShoppingCart(customer1);
        cart1.addOrder(order1);
        cart1.addOrder(order2);

        //Store order into order set
        ordersSet.add(order1);
        ordersSet.add(order2);

        //Print all orders
        System.out.println("====  All Orders  ====\n" + ordersSet);

        Order order4 = null;
        try {
            //invalid order Quantity
            order4 = new Order(4, customer4, product3, -1);
        } catch (InvalidOrderException e) {
            e.printStackTrace();
        } catch (StockUnavailableException e) {
            e.printStackTrace();
        }

        ordersSet.add(order3);
        //cart1.addOrder(order3);

        //Print all orders
        System.out.println("====  All Orders  ====\n" + ordersSet);

        //view shopping cart of customer 1
        System.out.println("====  Customer Cart  ====\n");
        cart1.viewCart();

        //Remove Order by Order id from Cart
        try {
            cart1.removeOrder(3);
        } catch (OrderNotFoundException e) {
            e.printStackTrace();
        }

        //checkout from cart1 and generate bill
        cart1.checkout();


    }

}
