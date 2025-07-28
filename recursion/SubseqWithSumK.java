import java.util.List;
import java.util.ArrayList;

public class SubseqWithSumK {
    public static void findSubsequences(int[] array, int target) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(array, target, 0, 0, ds, ans);
    }

    public static void helper(int[] array, int target, int index, int currentSum, List<Integer> ds, List<List<Integer>> ans) {
        if (index == array.length) {
            if (currentSum == target) {
                ans.add(new ArrayList<>(ds)); // add a copy of ds
                System.out.println(ds);
            }
            return; // important to stop recursion here
        }

        // include the element
        ds.add(array[index]);
        helper(array, target, index + 1, currentSum + array[index], ds, ans);

        // exclude the element
        ds.remove(ds.size() - 1);
        helper(array, target, index + 1, currentSum, ds, ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;
        findSubsequences(arr, k);  // Expected Output: [1, 1] and [2]
    }
}
