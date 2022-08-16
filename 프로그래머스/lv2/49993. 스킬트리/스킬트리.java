class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] priority=new int[27];
        for(int i=0;i<skill.length();i++){
            priority[skill.charAt(i)-'A']=i+1;
        }
        
        for(int i=0;i<skill_trees.length;i++){
            int prio=1;
            boolean check=true;
            for(int j=0;j<skill_trees[i].length();j++){
                if(priority[skill_trees[i].charAt(j)-'A']>0){
                    if(priority[skill_trees[i].charAt(j)-'A']==prio){
                        prio++;
                    }else{
                        check=false;
                        break;
                    }
                }
            }
            if(check)answer++;
        }
        return answer;
    }
}