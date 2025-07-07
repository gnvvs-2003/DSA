public class Sqrt {
    public static int sqrt(int num){
        // using linear search 
        int ans = 1;
        for (int i = 0; i <=num/2; i++) {
            if (i*i<=num) {
                ans = i;
                continue;
            }
            else{
                break;
            }
        }
        return ans;
    }
    // using binary search
    public static int binarySqrt(int num){
        int ans = 1;
        int low = 1;
        int high = num/2;
        while (low<=high) {
            long mid = low+(high-low)/2;
            long midValue = mid*mid;
            // conditions
            if (midValue<num) {
                low = (int)mid+1;
                ans = (int)(mid);
            }
            else if(midValue==num){
                return (int)(midValue);
            }
            else{
                high = (int)mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int num = 104;
        if(sqrt(num)==binarySqrt(num)){
            System.out.println(sqrt(num));
        }
        else{
            System.out.println("Error");
        }
    }
}