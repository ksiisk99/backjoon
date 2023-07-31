import java.util.*;

class Solution {

    
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> a[0]==b[0] ? (a[1]-b[1]) : b[0]-a[0]);
        
        int answer = 1;
        int maxScore = 0;
        int sum = wanho[0]+wanho[1];
        
        for(int[] score: scores){
            // if(score[0]+score[1] > sum){
            //     if(score[1]<maxScore){
            //         if(score.equals(wanho)){
            //             return -1;
            //         }
            //     }else{
            //         answer++;
            //         maxScore = Math.max(maxScore, score[1]);
            //     }
            // }
            
            if(score[1]<maxScore){
                if(score.equals(wanho)) return -1;
            } else {
                maxScore = Math.max(maxScore, score[1]);
                if(score[0] + score[1] > sum) {
                    answer++;
                }
            }
        }
        
        
        //[3,2] [3,2] [2,1] [2,2*] [1,4]
        return answer;
    }
}