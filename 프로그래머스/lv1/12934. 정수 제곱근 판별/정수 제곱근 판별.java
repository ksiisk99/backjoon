class Solution {
    public long solution(long n) {
        double sqrt=Math.sqrt(n);
        long answer= -1;
        if((long)sqrt==(long)Math.ceil(sqrt)){
            sqrt++;
            answer=(long)Math.pow(sqrt,2);
        }
        return answer;
    }
}