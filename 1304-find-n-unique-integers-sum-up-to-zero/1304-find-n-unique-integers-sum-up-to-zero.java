class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        if(n == 1) {
            ans[0] = 0;
            
        }

        if(n % 2 != 0) {
            int index = n / 2;
            ans[index] = 0;
            int l = index - 1;
            int r = index + 1;

            int num = 1;
            while(l >= 0 && r < n){
                ans[l] = -1 * num;
                ans[r] = num;
                l--;
                r++;
                num++;
            }
        }
        else{
            int index = n / 2;
            int l = index - 1;
            int r = index;
            int num = 1;
            while(l >= 0 && r < n){
                ans[l] = -1 * num;
                ans[r] = num;
                l--;
                r++;
                num++;
            }
        }


        return ans;
    }
}