class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int MAX=-1;
        int MAX2=-1;
        for(int i=0;i<sizes.length;i++){
            int tmp=Math.min(sizes[i][0],sizes[i][1]);
            MAX=Math.max(MAX,sizes[i][0]);
            MAX=Math.max(MAX,sizes[i][1]);
            MAX2=Math.max(MAX2,tmp);
        }
        return MAX*MAX2;
    }
}