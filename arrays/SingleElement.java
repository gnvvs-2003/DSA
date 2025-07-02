public class SingleElement {
    public static int uniqueElement(int[]array){
        int ans = 0;
        for (int i : array) {
            ans^=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]array = {1,1,2,3,1,2,1,4,3,5,4};
        System.out.println(uniqueElement(array));
    }
}