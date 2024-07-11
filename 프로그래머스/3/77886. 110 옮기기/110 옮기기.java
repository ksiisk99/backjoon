class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        int idx=0;
        for(String x:s){
            answer[idx++]=func(x);
        }
        return answer;
    }
    
    String func(String x){
        int cnt = 0;
        StringBuilder tmp = new StringBuilder();
        
        int idx=0;
        for(int i=0;i<x.length();i++,idx++){
            tmp.append(x.charAt(i));
            if(tmp.length()>=3 && tmp.substring(idx-2, idx+1).equals("110")){
                cnt++;
                tmp.delete(idx-2,idx+1);
                idx-=3;
            }
        }
        
        int i = tmp.length()-1;
        for(;i>=0;i--){
            if(tmp.charAt(i)=='0')break;
        }
        //System.out.println(tmp+" "+i+" "+cnt);
        
        StringBuilder sb = new StringBuilder();
        for(int c=0;c<cnt;c++) {
            sb.append("110");
        }
        return tmp.substring(0,i+1)+sb.toString()+tmp.substring(i+1);
    }
}