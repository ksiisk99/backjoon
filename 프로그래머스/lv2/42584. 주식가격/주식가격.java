import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
		List<Integer>list=new ArrayList<>();
		
        for(int i=0;i<prices.length;i++){
            if(list.isEmpty()){
                list.add(i);
            }else{
            	boolean check=true;
                for(int j=list.size()-1;j>=0;j--){
                    int n=list.get(j);
                    if(prices[n]<=prices[i]){
                        answer[n]++;
                        if(check) {
                        	list.add(i);
                        	check=false;
                        }
                    }else{
                        list.remove((Integer)n);
                        answer[n]++;
                    }
                }               
                if(list.isEmpty())list.add(i);
            }
        }
        
        return answer;
    }
}