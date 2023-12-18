import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1=0;
        long sum2=0;
        for(int i=0;i<queue1.length;i++)sum1+=(long)queue1[i];
        for(int i=0;i<queue2.length;i++)sum2+=(long)queue2[i];
        long half=(sum1+sum2)/2;

        Queue<Integer>queueOne=new LinkedList<Integer>(Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new)));
        Queue<Integer>queueTwo=new LinkedList<Integer>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new)));

        int MAX=Math.max(queue1.length,queue2.length);

        while(answer<=MAX*30){
            if(sum1<sum2){
                sum2-=(long)queueTwo.peek();
                sum1+=(long)queueTwo.peek();
                queueOne.add(queueTwo.poll());
            }else if(sum1==half){
                return answer;
            }else{
                sum1-=(long)queueOne.peek();
                sum2+=(long)queueOne.peek();
                queueTwo.add(queueOne.poll());
            }
            answer++;
        }

    return -1;
    }
}
