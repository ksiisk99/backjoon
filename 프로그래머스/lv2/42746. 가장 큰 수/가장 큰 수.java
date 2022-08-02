import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer="";
        String[] strNumbers=Arrays.stream(numbers)
                                .mapToObj(n -> String.valueOf(n))
                                .toArray(String[]::new);
        Arrays.sort(strNumbers,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        if(strNumbers[0].equals("0"))return "0";
        for(String str:strNumbers){
            answer+=str;
        }
        return answer;
    }
}