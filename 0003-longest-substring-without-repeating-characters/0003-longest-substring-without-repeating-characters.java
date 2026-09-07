import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Track the last seen index of each ASCII character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);

            // If character was seen inside the current window, move the left pointer past it
            if (lastSeen[curr] >= left) {
                left = lastSeen[curr] + 1;
            }

            lastSeen[curr] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}