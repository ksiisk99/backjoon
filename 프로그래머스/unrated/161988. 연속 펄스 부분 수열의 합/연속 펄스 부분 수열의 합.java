class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        long[] arr = new long[sequence.length+1]; //1시작
        long[] arr2 = new long[sequence.length+1]; //-1시작
        
        arr[0]=sequence[0];
        arr2[0]=-sequence[0];
        answer = Math.max(arr[0],arr2[0]);
        for(int i=1;i<sequence.length;i++){
            if(i%2==0){
                arr[i]=(long)Math.max(sequence[i], sequence[i]+arr[i-1]);
                arr2[i]=(long)Math.max(-sequence[i], -sequence[i]+arr2[i-1]);
            } else {
                arr[i]=(long)Math.max(-sequence[i], -sequence[i]+arr[i-1]);
                arr2[i]=(long)Math.max(sequence[i], sequence[i]+arr2[i-1]);
            }
            answer = Math.max(answer,arr[i]);
            answer = Math.max(answer, arr2[i]);
        }
        return answer;
    }
}