import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class KthSmallestProduct {
    public static int kthSmallestProduct(int[]array1,int[]array2,int k){
        Arrays.sort(array1);
        Arrays.sort(array2);
        List<Integer> products = new ArrayList<>();
        for (int i : array2) {
            for (int j : array1) {
                products.add(i*j);
            }
        }
        Collections.sort(products);
        return products.get(k-1);
    }
    public static void main(String[]a){
        int [] array1 = {2,5};
        int [] array2 = {3,4};
        int k = 2;
        int ans = kthSmallestProduct(array1,array2,k);
        System.out.println(ans);
    }
}