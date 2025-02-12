

class Solution {
    public int maxEvents(int[][] events) {
        // Sort events by start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, count = 0, i = 0, n = events.length;

        while (i < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty()) {
                day = events[i][0]; // Start from the first available event
            }

            // Add all events that start on 'day'
            while (i < n && events[i][0] == day) {
                minHeap.add(events[i][1]); // Add event end time
                i++;
            }

            // Attend the event that ends the earliest
            minHeap.poll();
            count++;
            day++;

            // Remove expired events (end time < current day)
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
        }

        return count;
    }
}
