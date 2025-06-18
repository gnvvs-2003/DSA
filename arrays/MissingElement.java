public class MissingElement{
    public static int missingElement(int[]array){
        int n = array.length;
        int sum = 0;
        for (int i : array) {
            sum+=i;
        }
        int totalSum = n*(n+1)/2;
        return totalSum-sum;
    }
    public static void main(String[] args) {
        int[]array={0,3,1};
        System.out.println(missingElement(array));
    }
}