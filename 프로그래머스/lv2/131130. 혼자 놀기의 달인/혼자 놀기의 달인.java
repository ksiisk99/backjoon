import java.util.*;
class Solution {
    
    public int solution(int[] cards) {
        int answer = 1;
        int[] check=new int[cards.length];
        int[] count=new int[cards.length+1];
        
        int box=1;
        for(int i=0;i<cards.length;i++){
            if(check[cards[i]-1]==0){
                check[cards[i]-1]=box;
                int tmp=cards[i]-1;
                while(true){
                    check[tmp]=box;
                    tmp=cards[tmp]-1;
                    if(check[tmp]>0)break;
                }
            }
            box++;
        }
        
        for(int n:check){
            count[n]++;
        }
        Arrays.sort(count);
        
        return count[cards.length]*count[cards.length-1];
    }
}