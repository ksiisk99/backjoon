class Solution {
    
    static int GCD(int a,int b){
        return b>0?GCD(b,a%b):a;
    }
    
    public int[] solution(int n, int m) {
        int gcd=GCD(n,m);
        
        return new int[]{gcd,n*m/gcd};
    }
}