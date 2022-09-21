class Solution {
    public String solution(String s) {
        int size=s.length();
        return size%2==1
            ?s.substring(size/2,size/2+1)
            :s.substring(size/2-1,size/2+1);
    }
}