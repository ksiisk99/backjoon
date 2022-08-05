import java.util.*;
class Solution {
    static ArrayList<HashSet<Integer>> candidateKey;
    static int length;
    static int answer;
    
    public int solution(String[][] relation) {
        answer=0;
        candidateKey=new ArrayList<>();
        length=relation[0].length;
        for(int i=1;i<=length;i++){
            makeSet(-1,i,0,new HashSet<Integer>(),relation);
        }
        return answer;
    }
    
    void makeSet(int index,int target,int count, HashSet<Integer> set,String[][] relation){
        if(count==target){
            if(!isUnique(set,relation))return;
            for(HashSet<Integer>key:candidateKey){
                if(set.containsAll(key)){
                    return ;
                }
            }
            candidateKey.add(set);
            answer++;
            return;
        }
        for(int i=index+1;i<length;i++){
            HashSet<Integer>newSet=new HashSet<>(set);
            newSet.add(i);
            makeSet(i,target, count+1,newSet,relation);
        }
    }
    
    boolean isUnique(HashSet<Integer> set, String[][] relation){
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<relation.length;i++){
            String temp="";
            for(int index:set){
                temp+=relation[i][index]+"/";
            }
            if(!list.contains(temp)){
                list.add(temp);
            }else{
                return false;
            }
        }
        return true;
    }
    
    
}