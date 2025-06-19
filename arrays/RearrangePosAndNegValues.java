public class RearrangePosAndNegValues {
    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int negative = 1;
        int positive = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0){
                temp[positive] = nums[i];
                positive = positive + 2;
            }
            else{
                temp[negative] = nums[i];
                negative = negative + 2;
            }
        }
        return temp;
    }
    public static int[] rearrange(int[] arr) {
        int n = arr.length;
        int[] pos = new int[n];
        int[] neg = new int[n];
        int posIndex = 0, negIndex = 0;
        for (int value : arr) {
            if (value >= 0) {
                pos[posIndex++] = value;
            } else {
                neg[negIndex++] = value;
            }
        }
        int[] result = new int[n];
        int i = 0, p = 0, ng = 0;
        while (p < posIndex && ng < negIndex) {
            result[i++] = pos[p++];
            result[i++] = neg[ng++];
        }
        while (p < posIndex) result[i++] = pos[p++];
        while (ng < negIndex) result[i++] = neg[ng++];
        return result;
    }
    public static void main(String[] args) {
        int[] array = {3, 1, -2, -5, 2, -4};
        for (int i : rearrange(array)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : rearrangeArray(array)) {
            System.out.print(i+" ");
        }
    }
}
