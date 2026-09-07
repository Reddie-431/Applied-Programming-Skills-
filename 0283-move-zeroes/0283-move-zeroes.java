class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = 0;
        
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                // Swap only when needed to minimize write operations
                if (cur != lastNonZero) {
                    int temp = nums[lastNonZero];
                    nums[lastNonZero] = nums[cur];
                    nums[cur] = temp;
                }
                lastNonZero++;
            }
        }
    }
}