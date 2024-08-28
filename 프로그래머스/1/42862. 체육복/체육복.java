import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] check=new boolean[n+1];
        
        int lostCheck=0;
        
        Arrays.fill(check,true);
        for(int i:lost){
            lostCheck|=(1<<i);
            check[i]=false;
        }
        
        Arrays.sort(reserve);
        
        for(int i=reserve.length-1;i>=0;i--){
            if((lostCheck&(1<<reserve[i]))>0){
                check[reserve[i]]=true;
                continue;
            }
            
            if(reserve[i]==n)check[reserve[i]-1]=true;
            else{
                if(check[reserve[i]+1]){
                    check[reserve[i]-1]=true;
                }else{
                    check[reserve[i]+1]=true;
                }
            }
        }
      
        for(int i=1;i<=n;i++)if(check[i])answer++;
        
        return answer;
    }
}