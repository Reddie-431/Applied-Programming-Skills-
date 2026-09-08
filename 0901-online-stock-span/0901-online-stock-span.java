import java.util.Stack;

class StockSpanner {
    // Stack stores integer arrays in the format: {price, span}
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Accumulate the span of all previous days with a price <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price and its total calculated span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */