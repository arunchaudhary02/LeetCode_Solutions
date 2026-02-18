

class MyCalendarThree {
    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int curr = 0;
        int maxcurr = 0;

        for (int val : map.values()) {
            curr += val;
            maxcurr = Math.max(maxcurr, curr);
        }
        return maxcurr;
    }
}