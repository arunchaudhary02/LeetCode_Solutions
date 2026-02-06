class Solution {
    private void helper(int n,String val,List<String> ans){
        if(val.length()==n){
            ans.add(val);
            return;
        }
        helper(n,val+"1",ans);
        if(val.charAt(val.length()-1)!='0'){
            helper(n,val+"0",ans);
        }
    }
    public List<String> validStrings(int n) {
        List<String> ans=new ArrayList<>();
        helper(n,"0",ans);
        helper(n,"1",ans);
        return ans;
    }
}