import java.util.Arrays;

public class LongestConsecutiveSeq {
    public static int longestConsecutiveSeq(int[] array) {
        if (array.length == 0) return 0;
        Arrays.sort(array);
        int longestStreak = 1;
        int currentStreak = 1;
        int i = 1;
        while (i < array.length) {
            if (array[i] == array[i - 1]) {
                i++;
                continue;
            }
            if (array[i] == array[i - 1] + 1) {
                currentStreak++;
            } else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
            i++;
        }
        return Math.max(longestStreak, currentStreak);
    }

    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSeq(array)); // Output: 4
    }
}
