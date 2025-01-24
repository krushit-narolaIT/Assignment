abstract class GenericClass<E extends Number> {
    public abstract E add(E x, E y);
}

class MyInteger extends GenericClass<Integer> {
    @Override
    public Integer add(Integer x, Integer y) {
        return x + y;
    }
}

class MyDouble extends GenericClass<Double> {
    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }
}

public class GenericesExample3 {
    public static void main(String[] args) {
        MyInteger myI = new MyInteger();
        Integer i1 = 1, j1 = 2;
        Integer k1 = myI.add(i1, j1);
        System.out.println(k1);

        System.out.println("===================");

        MyDouble myD = new MyDouble();
        Double i2 = 1.0, j2 = 2.2;
        Double k2 = myD.add(i2, j2);
        System.out.println(k2);
    }
}