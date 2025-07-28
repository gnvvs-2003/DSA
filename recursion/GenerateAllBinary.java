public class GenerateAllBinary {

    public static void generateAllBinary(int n, StringBuilder currentBinary) {
        if (currentBinary.length() == n) {
            System.out.println(currentBinary);
            return;
        } else {
            // case-1 : append 0
            currentBinary.append('0');
            generateAllBinary(n, currentBinary);
            currentBinary.deleteCharAt(currentBinary.length() - 1);

            // case-2 : append 1
            currentBinary.append('1');
            generateAllBinary(n, currentBinary);
            currentBinary.deleteCharAt(currentBinary.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        generateAllBinary(n, new StringBuilder());
    }
}