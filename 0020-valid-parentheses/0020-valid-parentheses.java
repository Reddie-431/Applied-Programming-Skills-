import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket for every opening bracket
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If it's a closing bracket, it must match the top of the stack
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        
        // If the stack is empty, all brackets were properly closed
        return stack.isEmpty();
    }
}