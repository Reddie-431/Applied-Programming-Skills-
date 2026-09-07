import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckIn {
        final String station;
        final int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private final Map<Integer, CheckIn> checkInMap;
    private final Map<String, double[]> routeStats;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeStats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckIn startInfo = checkInMap.remove(id);
        String routeKey = startInfo.station + "->" + stationName;
        
        // stats[0] = sum of total travel time, stats[1] = total completed trips
        double[] stats = routeStats.computeIfAbsent(routeKey, k -> new double[2]);
        stats[0] += (t - startInfo.time);
        stats[1]++;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        double[] stats = routeStats.get(routeKey);
        return stats[0] / stats[1];
    }
}