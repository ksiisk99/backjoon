import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = Arrays.stream(score)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        
        for(int i=0;i<list.size();i+=m){
            int idx=i+m-1;
            if(idx<list.size())
                answer+=m*list.get(idx);
        }
        
        return answer;
    }
}