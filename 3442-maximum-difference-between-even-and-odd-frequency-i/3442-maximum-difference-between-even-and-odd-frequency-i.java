class Solution {
    public int maxDifference(String s) {
        int[] arr = new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']++;
        }
        int odd =0;
        int even = s.length();
        for(int i:arr){
            if(i%2==0 && i>0){
                even =Math.min(even,i);
            }
            else {
                odd= Math.max(odd,i);
            }
        }
        System.out.println(even+" "+odd);
        return odd-even;
        
    }
}