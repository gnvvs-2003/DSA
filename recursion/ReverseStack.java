import java.util.Stack;

public class ReverseStack {

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) {
            return;
        }else{
            int top = stack.pop();
            reverse(stack);
            // insert
            insertBottom(stack,top);
        }
    }

    public static void insertBottom(Stack<Integer> stack,int element){
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }else{
            int top = stack.pop();
            insertBottom(stack, element);
            stack.push(top);
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
        // [10, 2, -1, 29, 4, 26, -10, 2]
        reverse(stack);
        System.out.println(stack);
    }
}