class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int length=m+section[0]-1;
        for(int i=1;i<section.length && length<=n;i++){
            if(length<section[i]){
                answer++;
                length=section[i]+m-1;
            }
        }
        return answer;
    }
}