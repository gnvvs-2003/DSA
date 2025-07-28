import java.util.List;
import java.util.ArrayList;

public class Combinationsi {
    public static void helper(int index, int[] array, int target, List<Integer> ds, List<List<Integer>> ans) {
        // base cases
        // target = sum till now
        if (index == array.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        // if current element is less than target
        if (array[index] <= target) {
            ds.add(array[index]);
            helper(index, array, target - array[index], ds, ans);
            ds.remove(ds.size() - 1);
        }
        // else move forward
        helper(index + 1, array, target, ds, ans);
    }

    public static void combinations(int[] array, int target) {
        int index = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(index, array, target, ds, ans);
        for (List<Integer> combination : ans) {
            System.out.println(combination);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        int target = 7;
        combinations(arr, target);

    }
}