class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        
        int idx=0;
        for(int n:food){
            if(n%2==1)n--;
            for(int i=0;i<n/2;i++){
                answer.append(String.valueOf(idx));
            }
            idx++;
        }
        return answer.toString()+"0"+answer.reverse().toString();
    }
}