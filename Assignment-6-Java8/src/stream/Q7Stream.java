package stream;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*Q7. Stream Performance Analyze the performance of spliterator
and learn tips for efficient parallelization.*/
public class Q7Stream {
    public static void main(String[] args) {
        //numbers list with 1 to 99999
        List<Integer> numbersList = IntStream.rangeClosed(1, 99999)
                .boxed()
                .toList();

        //create stream from that list
        Stream<Integer> str1 = numbersList.stream();

        //comparision starts
        long startNow = System.currentTimeMillis();

        //split one half
        Spliterator<Integer> spliterator1 = str1.spliterator();

        //split another half from splititerator1
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();

        System.out.println("\nOutput from spliterator1: ");
        spliterator1.forEachRemaining((n) -> System.out.print(n + " "));

        System.out.println("\nOutput from spliterator2: ");
        spliterator2.forEachRemaining((n) -> System.out.print(n + " "));
        long endNow = System.currentTimeMillis();
        System.out.println("\nTime Taken by Splititerator :: " + (endNow - startNow));

        System.out.println("===================");
        Stream<Integer> str2 = numbersList.stream();
        startNow = System.currentTimeMillis();
        Iterator<Integer> iterator = numbersList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        endNow = System.currentTimeMillis();
        System.out.println("\nTime Taken by Iterator :: " + (endNow - startNow));
    }
}
