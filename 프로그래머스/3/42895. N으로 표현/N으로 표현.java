import java.util.*;

class Solution {
    private Set<Integer>[] sets;
    
    public void calc(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for(int n:a){
            for(int n2:b){
                union.add(n+n2);
                union.add(n-n2);
                union.add(n*n2);
                
                union.add(n2+n);
                union.add(n2-n);
                union.add(n2*n);
                
                if(n2!=0){
                    union.add(n/n2);
                }
                
                if(n!=0){
                    union.add(n2/n);
                }
            }
        }
    }
    
    public int repeat(int cnt, int N){
        int result = N;
        for(int i=1;i<cnt;i++){
            result*=10;
            result+=N;
        }
        return result;
    }
    
    boolean findAnswer(Set<Integer> set , int number){
        for(int n:set){
            if(n==number){
                return true;
            }
        }
        return false;
    }
    
    public int solution(int N, int number) {
        if(N==number)return 1;
        
        sets= new HashSet[9];
        for(int i=1;i<=8;i++){
            sets[i]=new HashSet<>();
        }
        
        sets[1].add(N);
        
        for(int i=2;i<=8;i++){
            int size = i/2;
            for(int j=1;j<=size;j++){
                calc(sets[i], sets[j], sets[i-j]);
            }
            
            sets[i].add(repeat(i,N));
            
            boolean isFinish = findAnswer(sets[i], number);
            if(isFinish){
                return i;
            }
        }
        
        return -1;
    }
}