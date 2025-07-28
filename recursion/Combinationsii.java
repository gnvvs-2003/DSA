import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Combinationsii {
    public static void helper(int index, int[] array, int target, List<Integer> ds, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < array.length; i++) {
            // Skip duplicates
            if (i > index && array[i] == array[i - 1]) {
                continue;
            }

            // Early break if element is greater than target
            if (array[i] > target) {
                break;
            }

            ds.add(array[i]); // use array[i] not array[index]
            helper(i + 1, array, target - array[i], ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public static void combinations(int[] array, int target) {
        Arrays.sort(array); // Important for skipping duplicates
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, array, target, new ArrayList<>(), ans);

        for (List<Integer> combination : ans) {
            System.out.println(combination);
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinations(arr, target);
    }
}
