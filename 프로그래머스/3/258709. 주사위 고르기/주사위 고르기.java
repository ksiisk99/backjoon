import java.util.*;

class Solution {
    int n;
    boolean[] visited;
    List<int[]> diceComb;
    List<Integer> scoreA;
    List<Integer> scoreB;
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        int[] answer = new int[n/2];
        
        visited=new boolean[n];
        diceComb = new ArrayList<>();
        
        permutation(0,0,new int[n/2]);
        
        int max = Integer.MIN_VALUE;
        for(int[] comA:diceComb) {
            int[] comB = new int[n/2];
            boolean[] other = new boolean[n];
            
            int index = 0;
            for(int choice:comA) {
                other[choice] = true;
            }
            
            for(int i=0;i<other.length;i++){
                if(!other[i]) {
                    comB[index]=i;
                    index++;
                }
            }
            
            scoreA = new ArrayList<>();
            scoreB = new ArrayList<>();
            
            combDice(0, comA, dice, 0, scoreA);
            combDice(0, comB, dice, 0, scoreB);
            
            Collections.sort(scoreA);
            Collections.sort(scoreB);
            
            int totalWinCount = 0;
            
            for(int a:scoreA) {
                int left = 0;
                int right = scoreB.size();
                
                while(left+1 < right) {
                    int mid = (left+ right) / 2;
                    
                    if(a>scoreB.get(mid)) {
                        left=mid;
                    } else {
                        right = mid;
                    }
                }
                
                totalWinCount += left;
            }
            
            if(totalWinCount > max) {
                max = totalWinCount;
                answer = comA;
            }
        }
        
        int[] answer2 = new int[n/2];
        if(n==2) {
            return new int[]{answer[0] + 1};
        } else {
            for(int i=0;i<answer.length;i++){
                answer2[i]=answer[i]+1;
            }
        }
        return answer2;
    }
    
    void combDice(int index, int[] dices, int[][] originDices, int sum, List<Integer> team) {
        if(index == dices.length) {
            team.add(sum);
            return;
        }
        
        for(int i=0;i<6;i++){
            combDice(index + 1, dices, originDices, sum+originDices[dices[index]][i], team);
        }
    }
    
    void permutation(int depth, int index, int[] arr) {
        if(depth == n/2) {
            diceComb.add(arr.clone());
            return;
        }
        
        for(int i=index;i<n;i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                permutation(depth+1, i+1, arr);
                visited[i] = false;
            }
        }
    }
}