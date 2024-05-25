import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] arr=new int[1001];
        
        for(int weight:weights){
            answer+=arr[weight];
            
            int num=weight*2;
            if(num%3==0 && num/3>=100 && num/3<=1000){
                arr[num/3]++;
            }
            if(num%4==0 && num/4>=100 && num/4<=1000){
                arr[num/4]++;
            }
            
            num=weight*3;
            if(num%2==0 && num/2>=100 && num/2<=1000){
                arr[num/2]++;
            }
            if(num%4==0 && num/4>=100 && num/4<=1000){
                arr[num/4]++;
            }
            
            num=weight*4;
            if(num%2==0 && num/2>=100 && num/2<=1000){
                arr[num/2]++;
            }
            if(num%3==0 && num/3>=100 && num/3<=1000){
                arr[num/3]++;
            }
            
            arr[weight]++;
        }
        
        return answer;
    }
}