import java.util.List;
import java.util.ArrayList;
public class GenerateParenthesis {
    public static List<String> generate(int n) {
        List<String> ans = new ArrayList<String>();
        return generatorHelper(n, 0, 0, "", ans);
    }

    public static List<String> generatorHelper(int n, int open, int close, String ds, List<String> ans) {
        // base case
        if (ds.length() == 2 * n) {
            ans.add(ds);
        }
        // open parenthesis are less
        if (open < n) {
            generatorHelper(n, open + 1, close, ds + "(", ans);
        }
        if (close < open) {
            generatorHelper(n, open, close + 1, ds + ")", ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generate(n));
    }
}