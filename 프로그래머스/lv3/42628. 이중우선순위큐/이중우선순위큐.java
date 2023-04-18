import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((n1,n2)->{return n2-n1;});
        PriorityQueue<Integer>pq2=new PriorityQueue<>();
        
        for(String oper:operations){
            StringTokenizer st=new StringTokenizer(oper);
            String o=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            
            if(o.equals("I")){
                pq.add(num);
                pq2.add(num);
            }else{
                if(num==1){
                    if(!pq.isEmpty()){
                        pq2.remove(pq.poll());
                    }
                }else{
                    if(!pq2.isEmpty()){
                        pq.remove(pq2.poll());
                    }
                }
            }
        }
        
        if(!pq.isEmpty() && !pq2.isEmpty()){
            return new int[]{pq.poll(),pq2.poll()};
        }else if(!pq.isEmpty()){
            return new int[]{pq.poll(),0};
        }else if(!pq.isEmpty()){
            return new int[]{0,pq2.poll()};
        }
        return new int[]{0,0};
    }
}