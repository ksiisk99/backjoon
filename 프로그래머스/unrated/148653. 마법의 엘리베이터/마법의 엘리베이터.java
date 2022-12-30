class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey!=0){
            int num=storey%10;
            
            if(num>5){
                storey+=(10-num);
                answer+=(10-num);
            } else if(num==5){
                int num2=storey%100/10;
                if(num2>=5){
                    storey+=(10-num);
                    answer+=(10-num);
                }else{
                    answer+=num;
                }
            } else {
                answer+=num;
            }
            storey=storey/10;
        }
        return answer;
    }
    
}