import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        StringTokenizer st;

        Map<String,String> map=new HashMap<String, String>();
        int idx=0;
        for(String next:record) {
            st=new StringTokenizer(next);
            String event=st.nextToken();
            String uid=st.nextToken();

            idx++;
            if(!event.equals("Leave")) {
                String nickName=st.nextToken();
                map.put(uid, nickName);
                if(event.equals("Change"))idx--;
            }
        }
        answer=new String[idx];
        idx=0;

        for(String next:record) {
            st=new StringTokenizer(next);
            String event=st.nextToken();
            String uid=st.nextToken();

            if(event.equals("Enter")) {
                answer[idx++]=map.get(uid)+"님이 들어왔습니다.";
            }else if(event.equals("Leave")) {
                answer[idx++]=map.get(uid)+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}