import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Remove element outside of the sliding window of size k
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            
            // If the element is already in the set, a duplicate within distance k exists
            if (!window.add(nums[i])) {
                return true;
            }
        }
        
        return false;
    }
}