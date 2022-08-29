class Solution {
    static boolean[] visit;
    static int maxScore=0;
    
    public void comb(int[] info, int[] answer,int[]tmp,int size,int cnt,int start){
        if(cnt==size){
            int lionScore=0;
            int apacheScore=0;
            for(int i=0;i<11;i++){
                if(info[i]==0 && tmp[i]==0 )continue;
                if(info[i]<tmp[i]){
                    lionScore+=10-i;
                }else{
                    apacheScore+=10-i;
                }
            }
            
            if(lionScore>apacheScore  && maxScore<=(lionScore-apacheScore)){
                if(maxScore==(lionScore-apacheScore) && !isBetter(answer,tmp))return;
                copyResult(answer,tmp);
                maxScore=(lionScore-apacheScore);
            }
            return;
        }
        
        for(int i=start;i<11;i++){
            tmp[i]++;
            comb(info,answer,tmp,size,cnt+1,i);
            tmp[i]--;
        }
    }
    
    public boolean isBetter(int[] answer,int[] ryanScores){
        for(int i=10;i>=0;i--){
            if(ryanScores[i]>answer[i])return true;
            else if(ryanScores[i]<answer[i])return false;
        }
        return false;
    }
    
   public void copyResult(int[] answer,int[] tmp){
       for(int i=0;i<11;i++)answer[i]=tmp[i];
   }
    
    
    
    public int[] solution(int n, int[] info) {
        int[] answer=new int[11];
        int[] tmp=new int[11];
        comb(info,answer,tmp,n,0,0);
        
        return maxScore==0?new int[]{-1}:answer;
    }
    
}