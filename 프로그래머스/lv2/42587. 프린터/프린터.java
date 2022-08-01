import java.util.*;

class Solution {
    static int[] priorityCnt;
    static class Node{
        int num,priority;
        Node(int num,int priority){
            this.num=num;
            this.priority=priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        priorityCnt=new int[10];
        Queue<Node>queue=new LinkedList<>();
        int maxPriority=0;
        for(int i=0;i<priorities.length;i++){
            priorityCnt[priorities[i]]++;
            queue.add(new Node(i,priorities[i]));
            maxPriority=Math.max(maxPriority,priorities[i]);
        }
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(maxPriority==node.priority){
                answer++;
                priorityCnt[node.priority]--;
                maxPriority=findMaxPriority();
                if(node.num==location){
                    break;
                }
            }else{
                queue.add(new Node(node.num,node.priority));
            }
            
        }
        return answer;
    }
    
    static int findMaxPriority(){
        int MAX=0;
        for(int i=1;i<10;i++){
            if(priorityCnt[i]>0)
                MAX=Math.max(MAX,i);
        }
        return MAX;
    }
}