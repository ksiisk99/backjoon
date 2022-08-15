class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int change=0;
        int deletedZero=0;
        while(s.length()!=1){
            StringBuilder sb=new StringBuilder();
            int zero=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    zero++;
                }
            }
            change++;
            deletedZero+=zero;
            int num=s.length()-zero;
            while(num!=0){
                sb.append(String.valueOf(num%2));
                num/=2;
            }
            s=sb.reverse().toString();
        }
        answer[0]=change;
        answer[1]=deletedZero;
        return answer;
    }
}