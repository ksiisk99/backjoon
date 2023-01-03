import java.util.*;
class Solution {
    
    public int solution(int[] elements) {
        Set<Integer>set = new HashSet<>();
        int[] arr = new int[elements.length*2-1];
        arr[0]=elements[0];
        for(int i=1;i<elements.length*2-1;i++){
            arr[i]=elements[i%elements.length]+arr[i-1];
        }
        
        for(int i=0;i<elements.length*2-1;i++){
            for(int j=0;j<i;j++){
                if(i-j<=elements.length){
                    set.add(arr[i]-arr[j]);
                }
            }
        }

        return set.size();
    }
}