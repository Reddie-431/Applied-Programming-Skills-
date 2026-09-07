import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integers to String representations
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // Custom sort: compare (b + a) with (a + b) to sort in descending order
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", the result is "0" (e.g., [0, 0])
        if (strs[0].equals("0")) {
            return "0";
        }

        // Concatenate strings into the final result
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}