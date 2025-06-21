public class SubarraySumK {
    public static int countSubArrayWithSumK(int[]array,int target){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum+=array[j];
                if (sum==target) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[]array = {3, 1, 2, 4};
        int target = 6;
        System.out.println(countSubArrayWithSumK(array,target));
    }
}