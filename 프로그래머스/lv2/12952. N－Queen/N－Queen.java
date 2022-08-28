class Solution {
    static boolean[] col;
    static boolean[] left;
    static boolean[] right;
    static int answer=0;
    
    static void back(int cnt,int n){
        if(cnt==n){
            answer++;
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!col[i] && !right[i+n-cnt] && !left[i+cnt]){
                col[i]=true;
                right[i+n-cnt]=true;
                left[i+cnt]=true;
                back(cnt+1,n);
                col[i]=false;
                right[i+n-cnt]=false;
                left[i+cnt]=false;
            }
        }
    }
    
    public int solution(int n) {
        col=new boolean[n];
        left=new boolean[n*2];
        right=new boolean[n*2];
        back(0,n);
        return answer;
    }
}