class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=brown;i>=3;i--){
            for(int j=i;j>=3;j--){
                if((i*2)+(j-2)*2==brown && (i-2)*(j-2)==yellow){
                    answer[0]=i;
                    answer[1]=j;
                    return answer;
                }
            }
        }
        return answer;
    }
}