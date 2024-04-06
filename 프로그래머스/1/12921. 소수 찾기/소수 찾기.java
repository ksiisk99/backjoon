import java.util.stream.*;

class Solution {
    public int solution(int n) {
        boolean[] prime=new boolean[n+1];
        
        for(int i=2;i<=n;i++){
            if(!prime[i]){
                for(int j=i*2;j<=n;j+=i){
                    prime[j]=true;
                }
            }
        }
    
        return (int)IntStream.range(2,n+1)
            .filter(i->!prime[i])
            .count();
    }
}