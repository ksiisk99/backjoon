class Solution {
    public int solution(int n) {
        int answer = 0;
        String binary=Integer.toBinaryString(n);
        int cnt=0;
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1')cnt++;
        }
        for(int i=n+1;i<=1000000;i++){
            String tmp=Integer.toBinaryString(i);
            int tmpCnt=0;
            for(int j=0;j<tmp.length();j++){
                if(tmp.charAt(j)=='1')tmpCnt++;
            }
            if(cnt==tmpCnt){
                answer=i;
                break;
            }
        }
        
//         if(cnt==binary.length()){
//             answer=(1<<binary.length());
//             cnt--;
//         }else{
            
//         }
//         for(int i=0;i<=cnt-1;i++){
//             answer|=(1<<(cnt-1-i));
//         }
        return answer;
    }
}