class Solution {
    public int solution(int[] nums) {
        int overlap=0;
        boolean[] check=new boolean[200001];
        for(int num:nums){
            if(check[num])
                overlap++;
            else
                check[num]=true;
        }
        
        int size=nums.length/2;
        int selectMax=nums.length-overlap;
        return size<=selectMax?size:selectMax;
    }
}