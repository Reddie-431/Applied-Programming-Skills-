import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        // The stack will store the indices of prices waiting for a discount
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // While the current price is less than or equal to the price at the top of the stack,
            // it means we found the discount for the item at the top of the stack.
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                prices[index] -= prices[i]; // Apply the discount directly in-place
            }
            // Push the current index onto the stack to wait for its own potential discount
            stack.push(i);
        }
        
        return prices;
    }
}