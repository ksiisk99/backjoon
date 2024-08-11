class Solution {
    static int[] operationArr;
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        cnt = 0;
        operationArr=new int[numbers.length];
        recursive(numbers,0,target);
        return cnt;
    }
    
    void recursive(int[] numbers,int n, int target){
        if(n==numbers.length){
            int result=numbers[0];
            if(operationArr[0]==0)
                result*=-1;
            
            for(int i=1;i<n;i++){
                if(operationArr[i]==1)
                    result+=numbers[i];
                else
                    result-=numbers[i];
            }
            if(result==target)cnt++;
            return;
        }
        
        for(int i=0;i<2;i++){
            operationArr[n]=operationArr[n]*(-1)+1;
            recursive(numbers,n+1,target);
        }
    }
    
}