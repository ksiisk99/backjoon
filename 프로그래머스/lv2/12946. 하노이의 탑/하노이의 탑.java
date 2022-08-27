class Solution {
    static int[][] answer;
    static int idx=0;
    static void hanoi(int N, int start,int mid,int to){
        if(N==1){
            answer[idx][0]=start;
            answer[idx++][1]=to;
            return;
        }
        hanoi(N-1,start,to,mid);
        answer[idx][0]=start;
        answer[idx++][1]=to;
        hanoi(N-1,mid,start,to);
    }
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,2,3);
        return answer;
    }
}