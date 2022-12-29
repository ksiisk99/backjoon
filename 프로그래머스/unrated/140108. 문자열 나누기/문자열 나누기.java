

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length()>0){
            int cnt = 1;
            int cnt2 = 0;
            answer++;
            int i=1;
            char criteria = s.charAt(0);
            for(;i<s.length();i++){
                if(criteria == s.charAt(i)){
                    cnt++;
                }else{
                    cnt2++;
                }
                
                if(cnt==cnt2)break;
            }
            
            s=s.substring(i==s.length()?i:i+1,s.length());
        }
        
        return answer;
    }
}