class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++){
            int multiplication=answer*arr[i];
            int greatestCommonFactor=gcd(answer,arr[i]);
            answer=multiplication/greatestCommonFactor;
        }
        return answer;
    }
    
    public int gcd(int n1,int n2){
        if(n2==0)
            return n1;
        return gcd(n2,n1%n2);
    }
}