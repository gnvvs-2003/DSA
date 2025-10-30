// No of ways to climb a n step stairs 
// similar to Fibanocci
public class ClimbingStairs {
    public static void main(String[] args) {
        int noOfStairs = 6;

        if (noOfStairs <= 1) {
            System.out.println(1);
            return;
        }

        int prev = 1;
        int prev_2 = 1;
        int current = 0;

        for (int i = 2; i <= noOfStairs; i++) {
            current = prev + prev_2;
            prev_2 = prev;
            prev = current;
        }

        System.out.println(current);
    }
}
