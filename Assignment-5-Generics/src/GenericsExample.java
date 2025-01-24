class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

public class GenericsExample {
    public static void main(String[] args) {
        Test<Integer> test = new Test<Integer>(225);
        System.out.println(test.getObject());

        Test<String> test2 = new Test<String>("Krushit");
        System.out.println(test2.getObject());
    }
}