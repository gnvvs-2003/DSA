public class LeaderElements {
    public static int[] leaderElements(int[] array) {
        int n = array.length;
        int[] leaders = new int[n];
        int count = 0;
        int maxTillNow = array[n - 1];
        leaders[count++] = maxTillNow;

        for (int i = n - 2; i >= 0; i--) {
            if (array[i] >= maxTillNow) {
                maxTillNow = array[i];
                leaders[count++] = maxTillNow;
            }
        }
        for (int i = 0; i < count / 2; i++) {
            int temp = leaders[i];
            leaders[i] = leaders[count - 1 - i];
            leaders[count - 1 - i] = temp;
        }
        int[] result = new int[count];
        System.arraycopy(leaders, 0, result, 0, count);
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 9, 2, 4, 7, 3, 1, 0, 1, 4, 5, 0};
        for (int i : leaderElements(array)) {
            System.out.print(i + " ");
        }
    }
}
