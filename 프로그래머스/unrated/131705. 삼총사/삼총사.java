class Solution {
    
    static int recur(int sum, int[] number, int n, int cnt){
        if(cnt==3 && sum==0)return 1;
        
        int rst=0;
        for(int i=n;i<number.length;i++){
            rst+=recur(sum+number[i],number,i+1,cnt+1);
        }
        return rst;
    }
    
    public int solution(int[] number) {
        return recur(0,number,0,0);
    }
}