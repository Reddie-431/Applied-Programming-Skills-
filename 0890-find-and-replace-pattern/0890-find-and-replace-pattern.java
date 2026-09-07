import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] pToW = new int[26];
        int[] wToP = new int[26];

        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // If neither character has been mapped yet, establish a two-way mapping
            if (pToW[p - 'a'] == 0 && wToP[w - 'a'] == 0) {
                pToW[p - 'a'] = w;
                wToP[w - 'a'] = p;
            } 
            // If mapping exists, verify bijection holds in both directions
            else if (pToW[p - 'a'] != w || wToP[w - 'a'] != p) {
                return false;
            }
        }
        return true;
    }
}