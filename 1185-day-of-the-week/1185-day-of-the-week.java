class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        // Month offset array
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        
        // If month is Jan or Feb, treat as month 13 or 14 of the previous year
        if (month < 3) {
            year -= 1;
        }
        
        int dayIndex = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
        
        return days[dayIndex];
    }
}