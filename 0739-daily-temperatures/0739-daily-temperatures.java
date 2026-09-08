import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        // Stack will store the indices of the temperatures
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // While the current temperature is warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                // The number of days is the difference between the current index and the popped index
                answer[prevIndex] = i - prevIndex;
            }
            // Push the current index onto the stack to wait for a warmer day
            stack.push(i);
        }
        
        return answer;
    }
}