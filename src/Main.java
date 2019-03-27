import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        // Test
        System.out.println(check("([{}])"));
        System.out.println(check("([{)"));
        System.out.println(check("([{]})"));
        System.out.println(check("((([])))"));
        System.out.println(check(" "));
        System.out.println(check(""));
    }

    private static boolean check(String brackets_input) {
        if (brackets_input.isBlank()){
            return false;
        }
        char[] brackets_array = brackets_input.toCharArray();
        Stack<Character> brackets_list = new Stack<>();
        for (char c : brackets_array) {
            if (c == '(' || c == '[' || c == '{') {
                brackets_list.push(c);
            } else if ((c == ')') && (brackets_list.peek() == '(')) {
                brackets_list.pop();
            } else if ((c == ']') && (brackets_list.peek() == '[')) {
                brackets_list.pop();
            } else if ((c == '}') && (brackets_list.peek() == '{')) {
                brackets_list.pop();
            } else {
                return false;
            }
        }
        return brackets_list.isEmpty();
    }
}
