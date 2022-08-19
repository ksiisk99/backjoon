import java.util.*;

class Solution {
    static List<File>list=new ArrayList<>();
	
	static class File implements Comparable<File>{
        String head;
        int num;
        String tail;
        int idx;
        
        public File(String head, int num, int idx, String tail) {
			super();
			this.head = head;
			this.num = num;
			this.idx = idx;
            this.tail=tail;
		}
        
		@Override
        public int compareTo(File f){
            if(this.head.compareTo(f.head)>0){
                return 1;
            }else if(this.head.compareTo(f.head)==0){
                return this.num-f.num;
            }return -1;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer=new String[files.length];
        for(int i=0;i<files.length;i++) {
        	String head="";
        	String num="";
            String tail="";
        	boolean check=true;
        	for(int j=0;j<files[i].length();j++) {
        		if(check && files[i].charAt(j)>='0' && files[i].charAt(j)<='9') {
        			num+=String.valueOf(files[i].charAt(j));
        		}else {
        			if(num.length()>=1) {
                        check=false;
        				tail+=String.valueOf(files[i].charAt(j));
        				continue;
        			}
        			head+=String.valueOf(files[i].charAt(j));
        		}
        	}
            list.add(new File(head.toUpperCase(),Integer.parseInt(num),i,tail));
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            answer[i]=files[list.get(i).idx];
        }
        return answer;
    }
}