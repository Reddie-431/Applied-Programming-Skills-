class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        
        // Step 1: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}