class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        boolean[] checkNum=new boolean[46];
        int[] rank={6,6,5,4,3,2,1};
        
        for(int num:win_nums){
            checkNum[num]=true;
        }
        
        int equalCnt=0;
        int zeroCnt=0;
        for(int num:lottos){
            if(num==0)zeroCnt++;
            if(checkNum[num])equalCnt++;
        }
        answer[1]=rank[equalCnt];
        answer[0]=rank[equalCnt+zeroCnt];
        return answer;
    }
}