public class factorial {

    public static void main(String[] args) {
        System.out.println("factorial : "+factorial(3));
    }

    public static int factorial(int i) {
        if (i == 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }
}
