class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        int[][] dist = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for(int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for(int via = 0; via < 26; via++) {
            for(int i = 0; i < 26; i++) {
                for(int j = 0; j < 26; j++) {
                    if(dist[i][via] == Integer.MAX_VALUE || dist[via][j] == Integer.MAX_VALUE){
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]); 
                }
            }
        }

        long ans = 0;

        for(int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';

            if(dist[from][to] == Integer.MAX_VALUE) {
                return -1;
            }

            ans += dist[from][to];
        }

        return ans;
    }
}