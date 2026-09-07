import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Use TreeMap with reverse order comparator to store heights in descending order
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        
        // Convert map values directly into a String array
        return map.values().toArray(new String[0]);
    }
}