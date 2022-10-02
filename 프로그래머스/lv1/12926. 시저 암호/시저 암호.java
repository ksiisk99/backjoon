class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
        
            if(c>='A' && c<='Z'){
                c+=n;
                answer+=String.valueOf((char)(c>90?64+(c-90):c));
            }else if(c>='a' && c<='z'){
                c+=n;
                answer+=String.valueOf((char)(c>122?96+(c-122):c));
            }else{
                answer+=" ";
            }
        }
        return answer;
    }
}