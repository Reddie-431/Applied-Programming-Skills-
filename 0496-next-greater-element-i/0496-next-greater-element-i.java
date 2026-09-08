import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Maps a number to its next greater element
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Monotonic stack to keep track of elements waiting for their next greater element
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 to populate the map
        for (int num : nums2) {
            // If we find a greater element, map it to the elements waiting in the stack
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push the current number onto the stack to wait for its next greater element
            stack.push(num);
        }
        
        // Build the result array for nums1 using our pre-computed map
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ans;
    }
}