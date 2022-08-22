class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        int idx=0;
        for(long i=begin;i<=end;i++){
            if(i==1){answer[idx++]=0;continue;}
            boolean check=false;
            int j=2;
            for(;j*j<=i;j++){
                if(i%j==0 && i/j<=10000000){
                    check=true;
                    break;
                }
            }
            if(check)answer[idx++]=(int)(i/j);
            else answer[idx++]=1;
        }
        return answer;
    }
    
  
}