import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class ThreeSum{
    public static List<List<Integer>> threeSum(int[]array){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        int n = array.length;
        for(int i=0;i<n;i++){
            // skipping duplicates
            if(i>0 && array[i]==array[i-1] ){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while (left<right) {
                int sum = array[i]+array[left]+array[right];
                // case -1 sum==0
                if (sum==0) {
                    res.add(Arrays.asList(array[i],array[left],array[right]));
                    // move the left and right by one place
                    left++;
                    right--;
                    // repeat the process with skipping the duplicates
                    while (left<right && array[left]==array[left-1]) {
                        left++;
                    }
                    while (left<right && array[right]==array[right+1]) {
                        right--;
                    }
                }
                // case-2 sum<0
                else if (sum<0) {
                    left++;
                }
                // case -3 sum>0
                else{
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[]a){
        int [] array = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : threeSum(array)) {
            System.out.println(list);
        }
    }
}