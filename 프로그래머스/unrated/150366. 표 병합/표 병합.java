import java.util.*;
import java.util.stream.*;

class Solution {
    private String[] board=new String[2501];
    private int[] parent = new int[2501];
    
    public String[] solution(String[] commands) {
        List<String>answer = new ArrayList<String>();
        for(int i=1;i<=2500;i++){
            board[i] = "EMPTY";
            parent[i] = i;
        }
        
        for(String str: commands) {
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();
            
            switch(command) {
                case "UPDATE":
                    String s = st.nextToken();
                    String s2 = st.nextToken();
                    if(st.hasMoreTokens()) {
                        update(Integer.parseInt(s), Integer.parseInt(s2), st.nextToken());
                    } else {
                        updateName(s, s2);
                    }
                    break;
                case "MERGE":
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    int r2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());
                    merge(r, c, r2, c2);
                    break;
                case "UNMERGE":
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    unmerge(r, c);
                    break;
                case "PRINT":
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    int pos = parent[calcPosition(r,c)];
                    answer.add(board[pos]);
            }
        }
        
        return answer.stream()
            .toArray(String[]::new);
    }
    
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
    public int calcPosition(int r, int c){
        return (r-1) * 50 + c;
    }
    
    public void update(int r, int c, String name) {
        int pos = calcPosition(r,c);
        int parent1 = parent[pos];
        board[parent1]=name;
    }
    
    public void updateName(String fromName, String toName) {
        for(int i=1;i<=2500;i++){
            if(board[i].equals(fromName)) {
                board[i] = toName;
            }
        }
    }
    
    public void unmerge(int r, int c){
        int pos = calcPosition(r,c);
        int parent1 = parent[pos];
        String tmp = board[parent1];
        
        for(int i=1;i<=2500;i++){
            if(parent[i]==parent1) {
                board[i]="EMPTY";
                parent[i]=i;
            }
        }
        board[pos]=tmp;
    }
    
    
    public void union(int pos1, int pos2) {
        if(board[pos1].equals("EMPTY") && !board[pos2].equals("EMPTY")){
            board[pos1] = board[pos2];
        } else {
            board[pos2] = board[pos1];
        }
    }
    
    public void merge(int r,int c, int r2, int c2) {
        int pos1 = calcPosition(r,c);
        int pos2 = calcPosition(r2,c2);
        
        int parent1 = parent[pos1];
        int parent2= parent[pos2];
        
        if(parent1!=parent2){
            for(int i=1;i<=2500;i++){
                if(parent[i] == parent2) parent[i]=parent1;
            }
            
            union(parent1, parent2);
        }
        
    }
}