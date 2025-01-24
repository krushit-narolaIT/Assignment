import java.util.ArrayList;
import java.util.List;

class Animal {
}

class Dog extends Animal {
}

class Cat {

}

class Test3<T extends Number> {
    T obj;

    Test3(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

public class GenericsExample4 {
    public static void main(String[] args) {
        //cannot take String
        // Test3<String> testString = new Test3<>("Krushit");

        Test3<Double> test = new Test3<>(5.2);
        System.out.println("Test3 object: " + test.getObject());

        // can not add elements to the collection declared with the extends wildcard
        List<? extends Number> numbers = new ArrayList<Integer>();
        //numbers.add(5);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        List<? extends Number> numberList = list;
        System.out.println("Numberlist: " + numberList);

        List<? super Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Dog());
        //animals.add(new Cat());
        System.out.println("Animals :: " + animals);
    }
}
