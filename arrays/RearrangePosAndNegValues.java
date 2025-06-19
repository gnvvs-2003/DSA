public class RearrangePosAndNegValues {
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
    }
}
