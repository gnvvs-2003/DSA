public class CheckPrime{
    public static void main(String[] args) {
        int n = 100;
        boolean primeStatus = true;
        if (n <= 1) {
            primeStatus = false;
        } else {
            for (int currentNumber = 2; currentNumber <= n / 2; currentNumber++) {
                if (n % currentNumber == 0) {
                    primeStatus = false;
                    break;
                }
            }
        }
        System.out.println("The prime status of number " + n + " is " + primeStatus);
    }
}