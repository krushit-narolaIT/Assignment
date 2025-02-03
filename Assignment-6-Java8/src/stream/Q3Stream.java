package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Q3.Group Objects by Category Create a stream.Product class with name and category.
Group products by their category using Collectors.groupingBy.*/
public class Q3Stream {
    public static void main(String[] args) {
        //list of products
        List<Product> products = Arrays.asList(
                new Product("TV", "Electronics"),
                new Product("Bike", "Vehicle"),
                new Product("Fridge", "Electronics"),
                new Product("BMW", "Vehicle"),
                new Product("Table", "Furniture")
        );

        products.stream()
                .collect(Collectors.groupingBy(prod -> prod.getCategory())) //group products by their category
                .forEach((category, items) -> System.out.println(category + ": " + items));
    }
}
