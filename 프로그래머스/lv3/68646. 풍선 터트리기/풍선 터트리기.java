class Solution {
    public int solution(int[] a) {
        if(a.length==1)return 1;
        
        int answer = 2;
        int[] rightMin = new int[a.length];
        int[] leftMin = new int[a.length];
        
        rightMin[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],a[i]);
        }
        
        leftMin[0] = a[0];
        for(int i=1;i<=a.length-2;i++){
            if(!(a[i]>leftMin[i-1] && a[i]>rightMin[i+1])) {
                answer++;
            }
            leftMin[i]=Math.min(leftMin[i-1], a[i]);
        }
        return answer;
    }
}

// -92 -92 -92 -92 -92 -92 -71 -68 -61 -33