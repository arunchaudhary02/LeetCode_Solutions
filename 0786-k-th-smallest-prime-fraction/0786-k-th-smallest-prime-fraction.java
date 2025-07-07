//Approach-1 (Using simple Heap solution as it's asking for kth smallest)
//T.C : O(n^2 * log(k))
//S.C : O(k)


class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                maxHeap.offer(new double[] { (double) arr[i] / arr[j], (double) i, (double) j});
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }


        double[] result = maxHeap.poll();
        return new int[] { arr[(int) result[1]], arr[(int) result[2]] };
    }
}


//Approach-2 (Optimising Approach-1)
//T.C : O((n+k)logn)
//S.C : O(n)

/*
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));

        int n = arr.length;
        for(int i = 0; i < n; i++) {
            minHeap.offer(new double[] {(double) arr[i] / arr[n - 1], (double) i, (double) n - 1});
        }

        int smallest = 1;

        while(smallest < k) {
            double[] curr = minHeap.poll();

            int i = (int) curr[1];
            int j = (int) curr[2] - 1;

            if (j > i) { // ✅ This check is important
                minHeap.offer(new double[] { (double) arr[i] / arr[j], i, j });
            }
            smallest++;
        }


        double[] result = minHeap.poll();
        return new int[] { arr[(int) result[1]], arr[(int) result[2]] };
    }
}
*/