class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxKadane = nums[0];
        int currentMax = 0;
        int minKadane = nums[0];
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane's algorithm for maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxKadane = Math.max(maxKadane, currentMax);

            // Inverted Kadane's algorithm for minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minKadane = Math.min(minKadane, currentMin);
        }

        // If all elements are negative, maxKadane gives the maximum single negative element.
        // Returning totalSum - minKadane in this case would yield 0 (an empty subarray), which is invalid.
        if (maxKadane < 0) {
            return maxKadane;
        }

        // Maximum of non-wrapped subarray sum vs wrapped subarray sum
        return Math.max(maxKadane, totalSum - minKadane);
    }
}