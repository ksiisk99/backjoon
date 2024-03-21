import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int index = -1;
        if(sort_by.equals("code")) {
            index=0;
        } else if(sort_by.equals("date")) {
            index=1;
        } else if(sort_by.equals("maximum")) {
            index=2;
        }else {
            index=3;
        }
        
        final int fIndex = index;
        Arrays.sort(data, Comparator.comparingInt(d -> d[fIndex]));
        
        if(ext.equals("code")) {
            index=0;
        } else if(ext.equals("date")) {
            index=1;
        } else if(ext.equals("maximum")) {
            index=2;
        }else {
            index=3;
        }
        
        List<int[]> list = new ArrayList<>();
        for(int[] d:data) {
            int value = d[index];
            System.out.println(value);
            if(value<val_ext) {
                list.add(new int[]{d[0],d[1],d[2],d[3]});
            }
        }
        
        int[][] answer = new int[list.size()][4];
        for(int i=0;i<list.size();i++) {
            answer[i][0]=list.get(i)[0];
            answer[i][1]=list.get(i)[1];
            answer[i][2]=list.get(i)[2];
            answer[i][3]=list.get(i)[3];
        }
        return answer;
    }
}