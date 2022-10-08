import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer>answer=new ArrayList<>();
        
        int size=answers.length;
        int[] first=new int[size];
        int[] second=new int[size];
        int[] third=new int[size];
        
        initFirst(first);
        initSecond(second);
        initThird(third);
        
        int[] cnt=new int[3];
        for(int i=0;i<size;i++){
            if(answers[i]==first[i]){
                cnt[0]++;
            }
            if(answers[i]==second[i]){
                cnt[1]++;
            }
            if(answers[i]==third[i]){
                cnt[2]++;
            }
        }
       
        answer.add(1);
        int MAX=cnt[0];
        for(int i=1;i<3;i++){
            if(cnt[i]==0)continue;
            
            if(MAX<cnt[i]){
                answer.clear();
                answer.add(i+1);
                MAX=cnt[i];
            }else if(MAX==cnt[i]){
                answer.add(i+1);
            }
        }
        
        return answer.stream()
            .mapToInt(i->i)
            .toArray();
    }
    
    static void initFirst(int[] arr){
        int n=1;
        for(int i=0;i<arr.length;i++){
            arr[i]=n++;
            if(n==6)n=1;
        }
    }
    static void initSecond(int[] arr){
        int n=1;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                arr[i]=2;
            }else{
                arr[i]=n++;
            }
            if(n==2)n=3;
            else if(n==6)n=1;
        }
    }
    static void initThird(int[] arr){
        int[] tmp={3,1,2,4,5};
        int idx=-1;
        for(int i=0;i<arr.length;i++){
            if(i%2==0)idx++;
            if(idx==5)idx=0;
            arr[i]=tmp[idx];
        }
        
    }
}