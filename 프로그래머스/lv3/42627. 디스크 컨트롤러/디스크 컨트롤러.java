import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        PriorityQueue<int[]>pq=new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        
        int end=0;
        int cnt=0;
        int jobIdx=0;
        while(cnt<jobs.length){
            while(jobIdx<jobs.length && jobs[jobIdx][0]<=end){
                pq.add(jobs[jobIdx++]);
            }
            
            if(pq.isEmpty()){
                end=jobs[jobIdx][0];
            }else{
                int[] cur=pq.poll();
                answer+=end+(cur[1]-cur[0]);
                end+=cur[1];
                cnt++;
            }
        }
        
        return answer / jobs.length;
    }
}