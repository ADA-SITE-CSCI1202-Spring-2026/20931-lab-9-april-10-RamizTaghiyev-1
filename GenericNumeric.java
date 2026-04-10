public class GenericNumeric<T extends Number> {

    private T num;

    public GenericNumeric(T num) {
        this.num = num;
    }

    public double reciprocal() {
        double x = num.doubleValue();

        if (x == 0) {
            throw new ArithmeticException("division by zero");
        }

        return 1.0 / x;
    }

    public double fractionalPart() {
        double x = num.doubleValue();
        return Math.abs(x - (long) x);
    }

    public <V extends Number> boolean absoluteEqual(V other) {
        double a = Math.abs(num.doubleValue());
        double b = Math.abs(other.doubleValue());
        return a == b;
    }

    public T getNum() {
        return num;
    }

    public static void main(String[] args) {
        GenericNumeric<Double> a = new GenericNumeric<>(9.76);
        System.out.println("num: " + a.getNum());
        System.out.printf("reciprocal: %.4f%n", a.reciprocal());
        System.out.printf("fractional: %.2f%n", a.fractionalPart());

        GenericNumeric<Integer> b = new GenericNumeric<>(4);
        System.out.println("\nnum: " + b.getNum());
        System.out.printf("reciprocal: %.4f%n", b.reciprocal());
        System.out.printf("fractional: %.2f%n", b.fractionalPart());

        GenericNumeric<Float> c = new GenericNumeric<>(-3.5f);
        System.out.println("\nnum: " + c.getNum());
        System.out.printf("reciprocal: %.4f%n", c.reciprocal());
        System.out.printf("fractional: %.2f%n", c.fractionalPart());

        GenericNumeric<Double> d = new GenericNumeric<>(-5.5);
        System.out.println("\nabs equal with 5.5f: " + d.absoluteEqual(5.5f));
        System.out.println("abs equal with 5.6f: " + d.absoluteEqual(5.6f));

        GenericNumeric<Integer> e = new GenericNumeric<>(-7);
        System.out.println("abs equal with 7L: " + e.absoluteEqual(7L));

        try {
            GenericNumeric<Integer> z = new GenericNumeric<>(0);
            System.out.println(z.reciprocal());
        } catch (ArithmeticException ex) {
            System.out.println("error: " + ex.getMessage());
        }
    }
}