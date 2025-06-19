public class Stocks1 {
    public static int maximumProfit(int[]array){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            minPrice = Integer.min(minPrice, array[i]);
            maxProfit = Integer.max(maxProfit, array[i]-minPrice);
        }
        return maxProfit;

    }
    public static void main(String[] args) {
        int[]array = {7,1,5,3,6,4};
        System.out.println(maximumProfit(array));
    }
}