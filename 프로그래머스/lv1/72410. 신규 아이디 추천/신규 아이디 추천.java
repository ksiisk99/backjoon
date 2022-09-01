class Solution {
    public String solution(String new_id) {
        String answer="";
        answer=new_id.toLowerCase();//1단계
        answer=removeAllOutOfRulesCharacter(answer);//2단계
        answer=replaceConsecutivePointWithOnePoint(answer);//3단계
        answer=removeStartAndEndPoint(answer); //4단계
        if(isEmptyCharacters(answer))answer="a"; //5단계
        if(isMoreThan16Characters(answer)){ //6단계
            answer=removeExceededCharacters(answer);
            answer=removeStartAndEndPoint(answer);               
        }
        while(isNotMoreThan2Characters(answer)){ //7단계
            answer=addLastChracter(answer);
        }
        return answer;
    }
    
    public String replaceConsecutivePointWithOnePoint(String str){
        boolean checkContinuous=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                if(!checkContinuous){
                    sb.append(String.valueOf(str.charAt(i)));
                    checkContinuous=true;
                }
            }else{
                sb.append(String.valueOf(str.charAt(i)));
                checkContinuous=false;
            }
        }
        return sb.toString();
    }
    
    public String addLastChracter(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.append(String.valueOf(str.charAt(str.length()-1)));
        return sb.toString();
    }
    public boolean isNotMoreThan2Characters(String str){
        return str.length()<=2?true:false;
    }
    public String removeExceededCharacters(String str){
        return str.substring(0,15);
    }
    
    public boolean isMoreThan16Characters(String str){
        return str.length()>15?true:false;
    }
    
    public boolean isEmptyCharacters(String str){
        return str.length()==0?true:false;
    }
    
    
    public String removeStartAndEndPoint(String str){
        if(str.startsWith(".")){
            str=str.substring(1,str.length());
        }
        if(str.endsWith(".")){
            str=str.substring(0,str.length()-1);
        }
        return str;
    }
    public String removeAllOutOfRulesCharacter(String str){
        StringBuilder sb=new StringBuilder();
        boolean overlapPoint=false;
        
        for(int i=0;i<str.length();i++){
            char alphabet=str.charAt(i);
            if((alphabet>='a' && alphabet<='z')
               || alphabet=='_' || alphabet=='-' || (alphabet>='0' && alphabet<='9') || alphabet=='.'){
                sb.append(String.valueOf(alphabet));
            }
        }
        return sb.toString();
    }
}