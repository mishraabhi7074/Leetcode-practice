class UndergroundSystem {

    Map<Integer,String> checkInStation = new HashMap<>();
    Map<Integer,Integer> checkInTime = new HashMap<>();
    Map<String,int[]> track = new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id,stationName);
        checkInTime.put(id,t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        String pair = checkInStation.get(id)+","+stationName;
        int time = t - checkInTime.get(id);
        int[] p = track.getOrDefault(pair,new int[2]);
        p[0] = p[0] + 1;
        p[1] = p[1] + time;
        track.put(pair, p);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String pair = startStation+","+endStation;
        if(!track.containsKey(pair))return 0;
        int[] p = track.get(pair);
        double ans = (double)p[1]/p[0];
        return ans;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */