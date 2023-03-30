class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx=0,idx2=0;
        
        for(String s:goal){
            if(idx<cards1.length && s.equals(cards1[idx])){
                idx++;
            }else if(idx2<cards2.length && s.equals(cards2[idx2])){
                idx2++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}