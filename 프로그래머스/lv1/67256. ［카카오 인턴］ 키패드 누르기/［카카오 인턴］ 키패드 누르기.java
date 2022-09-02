import java.util.*;
class Solution {
    static List<int[]>list;
    
    public void init(){
        list=new ArrayList<>();
        list.add(new int[]{4,2});
        list.add(new int[]{1,1});
        list.add(new int[]{1,2});
        list.add(new int[]{1,3});
        list.add(new int[]{2,1});
        list.add(new int[]{2,2});
        list.add(new int[]{2,3});
        list.add(new int[]{3,1});
        list.add(new int[]{3,2});
        list.add(new int[]{3,3});
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        String[] keyPad={"","L","","R","L","","R","L","","R"};
        init();
        
        int[] left={4,1};
        int[] right={4,3};
        
        for(int num:numbers){
            int[] tmp=list.get(num);
            if(keyPad[num].equals("")){
                int leftDist=Math.abs(left[0]-tmp[0])+Math.abs(left[1]-tmp[1]);
                int rightDist=Math.abs(right[0]-tmp[0])+Math.abs(right[1]-tmp[1]);
                if((leftDist<rightDist) || (leftDist==rightDist && hand.equals("left"))){
                    answer+="L";
                    left[0]=tmp[0];
                    left[1]=tmp[1];
                }else{
                    answer+="R";
                    right[0]=tmp[0];
                    right[1]=tmp[1];
                }
            }else if(keyPad[num].equals("L")){
                answer+="L";
                left[0]=tmp[0];
                left[1]=tmp[1];
            }else{
                answer+="R";
                right[0]=tmp[0];
                right[1]=tmp[1];
            }
        }
        
        return answer;
    }
}