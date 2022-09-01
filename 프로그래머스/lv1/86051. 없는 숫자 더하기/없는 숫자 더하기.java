class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int bitCheck=0;
        for(int num:numbers){
            bitCheck|=(1<<num);
        }
        for(int i=1;i<=9;i++){
            if((bitCheck&(1<<i))==0)answer+=i;
        }
        return answer;
    }
}