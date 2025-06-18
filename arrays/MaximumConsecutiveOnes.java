public class MaximumConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        int[] array2 = {1, 1, 1, 1}; // no zeros
        int[] array3 = {0, 1, 1, 0, 1, 1, 1, 0, 1}; // multiple groups
        System.out.println(findMaxConsecutiveOnes(array1)); // Output: 3
        System.out.println(findMaxConsecutiveOnes(array2)); // Output: 0
        System.out.println(findMaxConsecutiveOnes(array3)); // Output: 3
    }
}