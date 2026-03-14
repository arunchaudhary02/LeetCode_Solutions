class Solution {
    public int findTheWinner(int n, int k) {
        
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int position = 1;

        while(queue.size() > 1) {
            if(position == k) {
                queue.poll();
                position = 1;
            }
            else {
                queue.offer(queue.poll());
                position++;
            }
        }

        return queue.poll();
    }
}