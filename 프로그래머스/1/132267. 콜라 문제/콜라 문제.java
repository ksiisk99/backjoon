class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyBottle=0;
        int coke=0;
        
        while(n>=a){
            emptyBottle=n;
            coke=n/a*b;
            answer+=coke;
            
            n=coke;
            n+=(emptyBottle%a);
        }
        return answer;
    }
}