class Test2<T extends Number, U extends Number> {
    T obj1;
    U obj2;

    Test2(T obj1, U obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public Integer addInteger(T obj1, U obj2) {
        return obj1.intValue() + obj2.intValue();
    }

    public Double addDouble(T obj1, U obj2) {
        return obj1.doubleValue() + obj2.doubleValue();
    }

    @Override
    public String toString() {
        return "Test2{" +
                "obj1=" + obj1 +
                ", obj2=" + obj2 +
                '}';
    }
}

class GenericsExample2 {
    public static void main(String[] args) {
        Test2<Integer, Integer> obj = new Test2<>(40, 225);
        System.out.println(obj.toString());

        Integer result = obj.addInteger(50, 10);
        System.out.println("Result of addition: " + result);

       Integer result2 = obj.addInteger(50, 67);
        System.out.println("Result of addition: " + result2);

        Test2<Double, Integer> obj2 = new Test2<>(40.0, 225);
        System.out.println(obj2.toString());

        Double result3 = obj2.addDouble(50.0, 56);
        System.out.println("Result of addition: " + result3);
    }
}
