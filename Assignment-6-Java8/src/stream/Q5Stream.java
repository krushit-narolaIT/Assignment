package stream;

import java.util.stream.Collector;
import java.util.stream.IntStream;

/*Q5.Custom Collectors Implement a custom Collector to calculate the product of numbers in a stream.*/
public class Q5Stream {
    public static void main(String[] args) {
        int productOfNumberInStream = IntStream.of(1, 2, 3, 4, 5)
                .boxed()
                .collect(Collector.of(
                        () -> new int[]{1}, //create new array for store product with size 1
                        (a, b) -> a[0] *= b, //multiply each element with a[0]
                        (a1, a2) -> { // for parallel stream
                            a1[0] *= a2[0];
                            return a1;
                        },
                        a -> a[0] //return product
                ));
        System.out.println("stream.Product: " + productOfNumberInStream);
    }
}
