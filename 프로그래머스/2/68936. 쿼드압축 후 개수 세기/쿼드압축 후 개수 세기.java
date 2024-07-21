class Solution {
    static int[] answer=new int[2];
    public void division(int[][] arr, int x,int y,int n){
        int tmp=arr[x][y];
        boolean check=true;
        int zero=0;
        int one=0;
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(tmp!=arr[i][j]){
                    check=false;
                }
                if(arr[i][j]==0)zero++;
                else one++;
            }
        }
        
        if(check){
            if(zero>0)answer[0]++;
            else answer[1]++;
            return;
        }
        if(n<=2){
            answer[0]+=zero;
            answer[1]+=one;
            return;
        }
        
        division(arr,x,y,n/2);
        division(arr,x,y+n/2,n/2);
        division(arr,x+n/2,y,n/2);
        division(arr,x+n/2,y+n/2,n/2);
    }
    public int[] solution(int[][] arr) {  
        division(arr,0,0,arr.length);
        return answer;
    }
}