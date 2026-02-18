class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        
        TreeMap<Integer, Long> events = new TreeMap<>();

        for(int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            events.put(start, events.getOrDefault(start, 0L) + color);
            events.put(end, events.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();

        long sum = 0;
        Integer previous = null;

        for(Map.Entry<Integer, Long> entry : events.entrySet()) {
            int currPoint = entry.getKey();

            if(previous != null && sum > 0) {
                result.add(Arrays.asList((long) previous, (long) currPoint, (long) sum));
            }

            sum += entry.getValue();
            previous = currPoint;
        }

        return result;
    }
}