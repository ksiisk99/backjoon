import java.util.*;

class Solution {
    
    static class Element implements Comparable<Element>{
        int idx,cnt;
        Element(int idx,int cnt){
            this.idx=idx;
            this.cnt=cnt;
        }
        
        @Override
        public int compareTo(Element o){
            return cnt-o.cnt;
        }
    }
    
    public int[] solution(String s) {
        List<Integer>answer=new ArrayList<>();
        boolean[] visit=new boolean[100001];
        String[] arr=new String[100001];
        List<Element>list=new ArrayList<>();
        
        int start=0,size=0;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='{'){
                start=i+1;
                i++;
            }else if(s.charAt(i)=='}'){
                arr[size++]=s.substring(start,i);
                list.add(new Element(size-1,arr[size-1].split(",").length));
            }
        }
        Collections.sort(list);
        
        for(Element element:list){
            int idx=element.idx;
            for(String tmp:arr[idx].split(",")){
                int num=Integer.parseInt(tmp);
                if(!visit[num]){
                    answer.add(num);
                    visit[num]=true;
                }
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}