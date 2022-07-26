import java.util.*;

class Solution {    
    static char[] arr;
    static List<String> list=new ArrayList<String>();
	static int MAX=-1;
    
    static void recursive(String[] orders, int n,int size,int idx){
        if(n==size) {
			String tmp=String.valueOf(arr);			
			int cnt=0;
			for(int i=0;i<orders.length;i++) {
				boolean check=true;
				for(int j=0;j<size;j++) {
					if(orders[i].indexOf(tmp.charAt(j))==-1) {
						check=false;
						break;
					}
				}
				if(check)cnt++;
			}
			if(cnt<2)return;
			if(MAX<cnt) {
				MAX=cnt;
				list.clear();
				list.add(tmp);
			}else if(MAX==cnt) {
				list.add(tmp);
			}
			return;
		}
		for(int i=(idx-65);i<26;i++) {
			arr[n]=(char)(i+65);
			recursive(orders,n+1,size,(i+65)+1);
		}
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> result=new ArrayList<>();
        for(int i=0;i<course.length;i++){
            arr=new char[course[i]];
            recursive(orders,0,course[i],65);
            MAX=-1;
            result.addAll(list);
            list.clear();
        }
        Collections.sort(result);
       
        return result.toArray(new String[result.size()]);
    }
}