class Solution {
    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<int []> maxHeap =  new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if(a > 0) maxHeap.offer(new int[] {a, 'a'});
        if(b > 0) maxHeap.offer(new int[] {b, 'b'});
        if(c > 0) maxHeap.offer(new int[] {c, 'c'});

        StringBuilder result = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            char char1 =(char) current[1];
            if(result.length() >= 2 && result.charAt(result.length() - 1) == char1 && result.charAt(result.length() - 2) == char1) {
                if(maxHeap.isEmpty()) break;
                int[] next = maxHeap.poll();
                char char2 =(char) next[1];
                result.append(char2);
                if(--next[0] > 0) maxHeap.offer(next);
                maxHeap.offer(current);
            }
            else {
                result.append(char1);
                if(--current[0] > 0) maxHeap.offer(current);
            }
            
        }

        return result.toString();
    }
}