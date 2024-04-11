class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer+=calculatePower(i,limit, power);
        }
        return answer;
    }
    
    public int calculatePower(int number,int limit,int power){
        int result = 0;
        for(int i=1;i*i<=number;i++){
            if(number==i*i){
                result++;
            } else if(number%i==0){
                result+=2;
            }
            if(result>limit){
                return power;
            }
        }
        return result;
    }
}