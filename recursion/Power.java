public class Power {
    /*
     * @gnvvs-2003 : x^n
     */
    public static double power(int x,int n){
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;

        if (n < 0) {
            return 1.0 / power(x, -n);
        }

        return x * power(x, n - 1);
    }
    public static void main(String[] args) {
        System.out.println(power(10, -1));
    }
}