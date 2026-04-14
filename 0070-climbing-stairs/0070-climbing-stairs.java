
// Brute Force

// class Solution {
//     public int climbStairs(int n) {
        
//         return solve(n);

//     }

//     private int solve(int n) {
//         if(n < 0) {
//             return 0;
//         }
//         if(n == 0) {
//             return 1;
//         }

//         int leftOneStep = climbStairs(n - 1);
//         int rightTwoStep = climbStairs(n - 2);

//         return leftOneStep + rightTwoStep;
//     }
// }

// Memorization 

// class Solution {
//     public int climbStairs(int n) {
//         Map<Integer, Integer> memo = new HashMap<>();
//         return solve(n, memo);

//     }

//     private int solve(int n, Map<Integer, Integer> memo) {
//         if(n < 0) {
//             return 0;
//         }

//         if(memo.containsKey(n)) {
//             return memo.get(n);
//         }
//         if(n == 0) {
//             return 1; // we got 1 way to cover all the stairs
//         }

//         int leftOneStep = climbStairs(n - 1);
//         int rightTwoStep = climbStairs(n - 2);

//         int ways = leftOneStep + rightTwoStep;
//         memo.put(n, ways);
//         return ways;
//     }
// }


//Approach-2 (Using Bottom Up DP)


// class Solution {
//     public int climbStairs(int n) {

//         if(n == 0 || n == 1 || n == 2) {
//             return n;
//         }
        
//         int[] dp = new int[n + 1]; // indexing starting from 1
        
//         dp[1] = 1;
//         dp[2] = 2;

//         for(int i = 3; i <= n; i++) {
//             dp[i] = dp[i - 1] + dp[i - 2];
//         }

//         return dp[n];

//     }
// }


//Approach-3 (Improving approach-2) -
//See that it looks nothing but a fibonacci sequence. You just have to store last 2 values (t[i-1] & t[i-2]) to find current value (t[i])

class Solution {
    public int climbStairs(int n) {

        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        
        int a = 1;
        int b = 2;
        int next = 0;

        for(int i = 3; i <= n; i++) {
            next = a + b;
            a = b;
            b = next;
        }

        return next;

    }
}


