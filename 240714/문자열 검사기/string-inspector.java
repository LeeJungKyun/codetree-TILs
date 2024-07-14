import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        System.out.println(isBalanced(input) ? 1 : 0);
    }
    
    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}