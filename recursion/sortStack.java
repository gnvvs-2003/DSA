import java.util.Stack;

public class sortStack {

    public static void sort(Stack<Integer> stack) {
        // base case
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sort(stack);
            insert(stack, top);
        }
    }

    public static void insert(Stack<Integer> stack, int top) {
        // base case
        if (stack.isEmpty() || stack.peek() <= top) {
            stack.push(top);
        } else {
            // swap
            int temp = stack.pop();
            insert(stack, top);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(2);
        stack.push(-1);
        stack.push(29);
        stack.push(4);
        stack.push(26);
        stack.push(-10);
        stack.push(2);

        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }
}