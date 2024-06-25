class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            long n=numbers[i];
            
            long tmp=1;
            while(true){
                if((n&tmp)==0){
                    if(tmp!=1){
                        n&=(~(tmp>>1));
                    }
                    answer[i]=n|tmp;
                    break;
                }
                tmp=(tmp<<1);
            }
        }
        return answer;
    }
}