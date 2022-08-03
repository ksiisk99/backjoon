import java.util.*;

class Solution {
    static boolean[] visit;
    static int[] select;
    static int[] prime;
    static int answer=0;
    
    static void permutation(String numbers, int cnt){
	    	String num="";
	    	for(int i=0;i<cnt;i++) {
	    		num+=String.valueOf(numbers.charAt(select[i]));
	    	}
	    	if(cnt>0){
	    		int num2=Integer.parseInt(num);
	    		if(prime[num2]==0) {
	    			boolean check=true;
	    			for(int i=2;i<num2;i++) {
	    				if(num2%i==0) {
	    					check=false;
	    					break;
	    				}
	    			}
	    			
	    			if(check) {
	    				prime[num2]=1;
	    				answer++;
	    			}
	    		}
 	        }
	        for(int i=0;i<numbers.length();i++){
	            if(!visit[i]){
	                visit[i]=true;
	                select[cnt]=i;
	                permutation(numbers,cnt+1);
	                visit[i]=false;
	            }
	        }
	    }
    
    public int solution(String numbers) {
        visit=new boolean[numbers.length()];
        select=new int[numbers.length()];
        prime=new int[10000000];
        prime[0]=prime[1]=1;

        permutation(numbers,0);
        return answer;
    }
}