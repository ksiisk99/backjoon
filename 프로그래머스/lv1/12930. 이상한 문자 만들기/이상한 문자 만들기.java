class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt=0;
        
        for(int i=0;i<s.length();i++,cnt++){
            char c=s.charAt(i);
            if(c>='A' && c<='Z'){
                answer+=cnt%2==0?String.valueOf(c):String.valueOf((char)(c+32));
            }else if(s.charAt(i)!=' '){
                answer+=cnt%2==0?String.valueOf((char)(c-32)):String.valueOf(c);
            }else{
                answer+=" ";
                cnt=-1;
            }
        }
        return answer;
    }
}