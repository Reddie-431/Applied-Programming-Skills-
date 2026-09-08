class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;
        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        int maxFreqCount = 0;
        for (int count : freq) {
            if (count == maxFreq) {
                maxFreqCount++;
            }
        }

        // Formula: (maxFreq - 1) groups of size (n + 1), plus the remaining max-frequency tasks
        int minIntervals = (maxFreq - 1) * (n + 1) + maxFreqCount;

        // If total tasks exceed calculated intervals, no idle slots are required
        return Math.max(tasks.length, minIntervals);
    }
}