class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1)return new int[]{-1};
        
        
        
        int MAX=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=MAX){
                idx=i;
                MAX=arr[i];
            }
        }
        
        int[] answer=new int[arr.length-1];
        int answerIdx=0;
        for(int i=0;i<arr.length;i++){
            if(i==idx)continue;
            answer[answerIdx++]=arr[i];
        }
        
        return answer;
    }
}