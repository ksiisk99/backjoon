class Solution {
    int result;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        int idx=0;
        for(long number:numbers){
            String binary = Long.toBinaryString(number);
            int height = (int)Math.floor(Math.log(number)/ Math.log(2))+1;
            int treeHeight = 1;
            int maxNode = 0;
            while(maxNode<height){
                maxNode = (int)(Math.pow(2,treeHeight++))-1;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<(maxNode-binary.length());i++){
                sb.append("0");
            }
            binary = sb.toString()+binary;
            
            int size = binary.length()-1;
            result = 1;
            isFullBinaryTree(binary, 0, size,  false);
            answer[idx++]=result;
        }
        return answer;
    }
    
    void isFullBinaryTree(String binary, int s,int e, boolean isDummyNode) {
        int mid=(s+e)/2;
        
        if(isDummyNode && binary.charAt(mid)=='1'){
            result = 0;
            return;
        }
        
        if(s!=e){
            isFullBinaryTree(binary, s, mid-1, binary.charAt(mid)=='0');
            isFullBinaryTree(binary, mid+1, e, binary.charAt(mid)=='0');
        }
    }
}
