class Solution {
    long calcGcd(long a,long b){
        if(b==0) return a;
        return calcGcd(b,a%b);
    }
    public long solution(int w, int h) {
        long answer = 1;
        long gcd=calcGcd(w,h);
        
        long a=w/gcd;
        long b=h/gcd;
        
        return ((long)w*(long)h)-(long)((a+b-1)*gcd);
    }
}