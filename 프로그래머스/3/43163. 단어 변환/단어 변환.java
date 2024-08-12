class Solution {
    int answer=Integer.MAX_VALUE;
    boolean[] visit;
    int SIZE=0;
    
    void dfs(String word, String target, int cnt, String[] words){
        if(word.equals(target)){
            answer = Math.min(answer,cnt);
            return;
        }
        
        for(int i=0;i<words.length;i++){
            if(visit[i])continue;
            
            int flag=0;
            for(int len=0;len<SIZE;len++){
                if(word.charAt(len)==words[i].charAt(len)){
                    flag++;
                }
            }
            if(flag>=SIZE-1){
                visit[i]=true;
                dfs(words[i], target, cnt+1, words);
                visit[i]=false;
            }
        }
        
        
    }
    public int solution(String begin, String target, String[] words) {
        visit=new boolean[words.length];
        SIZE=words[0].length();
        dfs(begin, target, 0, words);
        return answer==Integer.MAX_VALUE ? 0 : answer;
    }
}