class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int half = s.length() / 2;
        int balance = 0;

        for (int i = 0; i < half; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                balance++;
            }
            if (vowels.indexOf(s.charAt(i + half)) != -1) {
                balance--;
            }
        }

        return balance == 0;
    }
}