
class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        int cnt=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A' && s.charAt(i)<='z'){
                if(cnt>0)sb.append(String.valueOf(s.charAt(i)).toUpperCase());
                else sb.append(String.valueOf(s.charAt(i)).toLowerCase());
                cnt=0;
            }else{
                if(s.charAt(i)==' ')cnt++;
                else cnt=0;
                sb.append(String.valueOf(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}
