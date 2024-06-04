import java.util.*;
import java.util.stream.*;

class Solution {
    int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    
    public boolean isDivisive(int gcdNum, List<Integer> arr){
        for(int n:arr){
            if(n%gcdNum!=0){
                return false;
            }
        }
        return true;
    }
    
    public boolean isNotDivisive(int gcdNum, List<Integer> arr){
        for(int n:arr){
            if(n%gcdNum==0){
                return false;
            }
        }
        return true;
    }
    
    public void calcDivisors(List<Integer>divisor, int gcdNum){
        for(int i=1;i<=Math.sqrt(gcdNum);i++){
            if(gcdNum%i==0){
                divisor.add(i);
                if(gcdNum/i!=i)divisor.add(gcdNum/i);
            }
        }
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        Set<Integer>setA = new HashSet<>(Arrays.stream(arrayA)
                .boxed()
                .collect(Collectors.toList()));
        Set<Integer>setB = new HashSet<>(Arrays.stream(arrayB)
                .boxed()
                .collect(Collectors.toList()));
        List<Integer>listA = new ArrayList<>(setA);
        List<Integer>listB = new ArrayList<>(setB);
        Collections.sort(listA);
        Collections.sort(listB);
        
        List<Integer>divisorA=new ArrayList<>();
        List<Integer>divisorB=new ArrayList<>();
        
        // int gcdA=gcd(listA.get(0),listA.get(1));
        // int gcdB=gcd(listB.get(0),listB.get(1));
        calcDivisors(divisorA,listA.get(0));
        calcDivisors(divisorB,listB.get(0));
        
        Collections.sort(divisorA,Comparator.reverseOrder());
        Collections.sort(divisorB,Comparator.reverseOrder());
        int answer=0;
        for(int n:divisorA){
            if(isDivisive(n,listA) && isNotDivisive(n,listB)){
                answer=n;
                break;
            }
        }
        
        for(int n:divisorB){
            if(isDivisive(n,listB) && isNotDivisive(n,listA) && answer<n){
                answer=n;
                break;
            }
        }
        
        return answer;
    }
    
}