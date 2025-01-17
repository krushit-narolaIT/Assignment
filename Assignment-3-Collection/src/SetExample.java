import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        SetExample setExample = new SetExample();
        System.out.println("==== HashSet Example ====");
        setExample.hashSetOps();

        System.out.println("==== LinkedHashSet Example ====");
        setExample.linkedHashSetOps();

        System.out.println("==== TreeSet Example ====");
        setExample.treeSetOps();
    }

    public void hashSetOps(){
        Set<String> hashSet = new HashSet<>();
        hashSet.add("India");
        hashSet.add("Brazil");
        hashSet.add(null);
        hashSet.add("India"); // it not allow duplicates
        System.out.println("HashSet: " + hashSet);
        System.out.println("Size of hashSet :: " + hashSet.size());

        Set<String> hashSet1 = new HashSet<>(15);

        //with initial capacity
        System.out.println("Size of hashSet :: " + hashSet.size());
    }

    public void linkedHashSetOps(){
        //preserve insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("USA");
        linkedHashSet.add("Germany");
        linkedHashSet.add(null);
        linkedHashSet.add("USA"); // no allow
        linkedHashSet.add("Finland");
        System.out.println("LinkedHashSet: " + linkedHashSet);
    }

    public void treeSetOps(){
        //preserves natural sorting order
        Set<String> treeSet = new TreeSet<>();
        try {
            treeSet.add("Canada");
            treeSet.add("Australia");
            treeSet.add("Brazil");
            treeSet.add(null); // this give null pointer exception from here onwards no element will store in set
            treeSet.add("Armania"); // not store in set
        } catch (NullPointerException nullPointerException){
            nullPointerException.getMessage();
        }

        System.out.println("TreeSet: " + treeSet);

        System.out.println("Iterating through TreeSet:");
        for (String country : treeSet) {
            System.out.println(country);
        }
    }
}
