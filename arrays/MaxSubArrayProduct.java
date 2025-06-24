public class MaxSubArrayProduct {
    public static int maxProduct(int[]array){
        int maxValue = Integer.MIN_VALUE;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int n = array.length;
        for(int i=0;i<n;i++){
            if (prefixProduct==0) {
                prefixProduct=1;
            }
            if (suffixProduct==0) {
                suffixProduct=1;
            }
            prefixProduct*=array[i];
            suffixProduct*=array[n-i-1];
            maxValue = Math.max(maxValue,Math.max(prefixProduct,suffixProduct));
        }
        return maxValue;

    }
    public static void main(String[] args) {
        int[]array = {1, 2, -3, 0, -4, -5};
        System.out.println(maxProduct(array));
    }
}