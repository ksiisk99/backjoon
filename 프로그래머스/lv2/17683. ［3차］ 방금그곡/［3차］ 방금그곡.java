class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer="";
        int MAX=-1;
        
        for(int t=0;t<musicinfos.length;t++){
            String[] music=musicinfos[t].split(",");
            String[] endTime=music[1].split(":");
            String[] startTime=music[0].split(":");
            
            int hour=Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0]);
            if(hour<0)hour+=24;
            int minute=Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]);
            int diff=(int) (hour*60+minute);
            String tmp="";
            
            for(int i=0,j=0;i<diff;){
            	tmp+=music[3].charAt(j);
                if(music[3].charAt(j)!='#') {
                	i++;
                }
                j++;
                if(j==music[3].length())j=0;
                if(i==diff && music[3].charAt(j)=='#')tmp+="#";
            }
            if(MAX>=(hour*60+minute))continue;
            
            for(int i=0;i<=tmp.length()-m.length();) {
            	int idx=tmp.indexOf(m, i);
            	if(idx!=-1 && idx+m.length()>=tmp.length()) {
            		answer=music[2];
                    MAX=(hour*60+minute);
            		break;
            	}
            	if(idx+m.length()>=tmp.length())break;
            	
            	if(idx!=-1) { //문자열 찾음
            		if(tmp.charAt(idx+m.length())!='#') { //조건에 만족함
            			MAX=hour*60+minute;
            			answer=music[2];
            			break;
            		}else {
            			i=idx+m.length()+1;
            		}
            	}else break;
            }
        }
        return MAX==-1?"(None)":answer;
    }
}