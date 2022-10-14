class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            int bit=arr1[i] | arr2[i];
            String rst="";
            
            for(int j=0;j<n;j++){
                if((bit&(1<<(n-j-1)))>0){
                    rst+="#";
                }else{
                    rst+=" ";
                }
            }
            
            answer[i]=rst;
        }
        
        return answer;
    }
}