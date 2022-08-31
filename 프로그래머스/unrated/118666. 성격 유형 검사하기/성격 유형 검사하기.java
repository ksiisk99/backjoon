class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] personalityScores=new int[26];
        int[] scores={0,3,2,1,0,1,2,3};
        char[] personality={'R','T','C','F','J','M','A','N'};
        
        for(int i=0;i<survey.length;i++){
            if(choices[i]>3){
                personalityScores[survey[i].charAt(1)-'A']+=scores[choices[i]];
            }else{
                personalityScores[survey[i].charAt(0)-'A']+=scores[choices[i]];
            }
        }
        for(int i=0;i<8;i+=2){
            if(personalityScores[personality[i]-'A']>=personalityScores[personality[i+1]-'A']){
                answer+=String.valueOf(personality[i]);
            }else{
                answer+=String.valueOf(personality[i+1]);
            }
        }
        return answer;
    }
}