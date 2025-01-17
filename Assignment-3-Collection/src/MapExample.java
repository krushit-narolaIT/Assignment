import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        MapExample mapExample = new MapExample();
        System.out.println("====== HashMap Operations =====");
        mapExample.hashMapOps();

        System.out.println("====== LinkedHashMap Operations =====");
        mapExample.linkedHashMapOps();

        System.out.println("====== TreeMap Operations =====");
        mapExample.treeMapOps();
    }

    public void hashMapOps() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("USA", "Washington D.C.");
        hashMap.put("Canada", "Ottawa");
        hashMap.put("Germany", "Berlin");
        hashMap.put("null", "Brazilia"); //allow only one null as key
        hashMap.put("null", "Tokyo"); //overwrites previous null value related value
        System.out.println("HashMap: " + hashMap);

        hashMap.put("Canada", "Toronto");

        System.out.println("Updated Map " + hashMap);

        hashMap.remove("USA");

        System.out.println("After removing USA :: " + hashMap);
    }

    public void linkedHashMapOps() {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Gujarat", "Ahmedabad");
        linkedHashMap.put("Andhrapradesh", "Telangana");
        linkedHashMap.put("null", "Tripura"); // allow one null
        linkedHashMap.put("Gujarat", "Gandhinagar"); // Overwrites old value
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }

    public void treeMapOps() {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("India", "Delhi");
        treeMap.put("Afghanistan", "Kabul");
        treeMap.put("Japan", "Tokyo");
        treeMap.put("null", "Tripura"); // allow null second time override it
        System.out.println("TreeMap: " + treeMap);

        System.out.println("Iterating through TreeMap:");
        System.out.println("Get Country Name From Map");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println("Country: " + entry.getKey() + ", Capital: " + entry.getValue());
        }

        System.out.println("Get Country Name From Map");
        for (String countryName : treeMap.keySet()) {
            System.out.println("key: " + countryName);
        }

        System.out.println("Get Country Name With Capital");
        for (String name : treeMap.keySet()) {
            String capital = treeMap.get(name);
            System.out.println("Key = " + name + ", Value = " + capital);
        }
    }
}
