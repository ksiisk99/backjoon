import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1=str1.toUpperCase();
		str2=str2.toUpperCase();
		String[] str1Arr=new String[str1.length()];
		String[] str2Arr=new String[str2.length()];
		Map<String,Integer>map1=new HashMap<String, Integer>();
		Map<String,Integer>map2=new HashMap<String, Integer>();
		
		int idx1=0,idx2=0;
		for(int i=0;i<str1.length()-1;i++) {
			char c=str1.charAt(i);
			if(c<'A' || c>'Z')continue;
			char c2=str1.charAt(i+1);
			if(c2<'A' || c2>'Z') {
				i++;
				continue;
			}
			str1Arr[idx1++]=String.valueOf(c)+String.valueOf(c2);
			if(map1.containsKey(str1Arr[idx1-1])) {
				map1.put(str1Arr[idx1-1], map1.get(str1Arr[idx1-1])+1);
			}else {
				map1.put(str1Arr[idx1-1], 1);
			}
		}	
		
		for(int i=0;i<str2.length()-1;i++) {
			char c=str2.charAt(i);
			if(c<'A' || c>'Z')continue;
			char c2=str2.charAt(i+1);
			if(c2<'A' || c2>'Z') {
				i++;
				continue;
			}
			str2Arr[idx2++]=String.valueOf(c)+String.valueOf(c2);
			if(map2.containsKey(str2Arr[idx2-1])) {
				map2.put(str2Arr[idx2-1], map2.get(str2Arr[idx2-1])+1);
			}else {
				map2.put(str2Arr[idx2-1], 1);
			}
		}
		int intersection=0;	
		for(int i=0;i<idx1;i++) {
			if(map2.containsKey(str1Arr[i])) {
				intersection+=Math.min(map1.get(str1Arr[i]), map2.get(str1Arr[i]));
				map2.remove(str1Arr[i]);
			}
		}
        if(intersection==0 && idx1==0 && idx2==0)return 65536;
		double result=intersection/(double)(idx1+idx2-intersection);
		return (int)Math.floor(result*65536);
    }
}