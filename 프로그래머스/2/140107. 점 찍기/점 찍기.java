class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i<=d;i+=k, answer++){
            long tmp = (long)(Math.pow(d,2)-Math.pow(i,2));
            long tmp2 = (long)Math.sqrt(tmp);
            
            answer+=tmp2/k;
        }
        return answer;
    }
}