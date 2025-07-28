// subsequences => a contigous or not contiguous which follows the order
// sub array => only contigous which follow the order

/*
 * [3,1,2]
 * sub arrays = [[],[3],[1],[2],[3,1],[1,2],[3,1,2]] = 7 ways
 * sub seq = [[],[3],[1],[2],[3,1],[3,2],[1,2],[3,1,2]] = 8 ways
 */

import java.util.*;

public class PrintAllSubseq {
    static void generateSubseq(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Take
        ds.add(nums[index]);
        generateSubseq(index + 1, nums, ds, ans);

        // Backtrack
        ds.remove(ds.size() - 1);

        // Not Take
        generateSubseq(index + 1, nums, ds, ans);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = new ArrayList<>();
        generateSubseq(0, nums, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}

// T(n) = O(2^n)
// S(n) = O(n)
