import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // maxDeque keeps elements in decreasing order (maximum at front)
        Deque<Integer> maxDeque = new ArrayDeque<>();
        // minDeque keeps elements in increasing order (minimum at front)
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);

            // Maintain increasing order in minDeque
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);

            // If the difference exceeds limit, shrink the window from the left
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }

            // Update the maximum length of a valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}