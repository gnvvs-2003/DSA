public class Factorial{
    public static int factorialOfANumber(int number){
        if(number==0){
            return 1;
        }
        return factorialOfANumber(number-1)*number;
    }
    public static void main(String[]a){
        int number = 6;
        int factorial = factorialOfANumber(number);
        System.out.println(factorial);
    }
}