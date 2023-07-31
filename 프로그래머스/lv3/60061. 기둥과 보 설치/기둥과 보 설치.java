import java.util.*;
import java.util.stream.*;

class Solution {
    boolean[][] pillar;
    boolean[][] bar;
    
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];
        
        int size = 0;
        for(int[] build: build_frame){
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];
            
            if(a==0 && b==1) {
                if(canBuildPillar(x,y)) {
                    size++;
                    pillar[x][y] = true;
                }
            } else if(a==1 && b==1) {
                if(canBuildBar(x,y)) {
                    size++;
                    bar[x][y]= true;
                }
            } else if(a==0 && b==0) {
                pillar[x][y]=false;
                if(canDelete(n)) {
                    size--;
                }else{
                    pillar[x][y]=true;
                }
            } else {
                bar[x][y]=false;
                if(canDelete(n)){
                    size--;
                }else{
                    bar[x][y]=true;
                }
            }
        }
        
        int[][] answer = new int[size][3];
        int idx=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(pillar[i][j]){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx++][2]=0;
                }
                
                if(bar[i][j]){
                    answer[idx][0]=i;
                    answer[idx][1]=j;
                    answer[idx++][2]=1;
                }
            }
        }
        
        return answer;
    }
    
    boolean canDelete(int n){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(pillar[i][j] && !canBuildPillar(i,j)){
                    return false;
                }
                
                if(bar[i][j] && !canBuildBar(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean canBuildBar(int x,int y){
        if(y>0 && (pillar[x][y-1] || pillar[x+1][y-1]) || x>0 && (bar[x-1][y] && bar[x+1][y])){
            return true;
        }
        return false;
    }
    
    boolean canBuildPillar(int x,int y) {
        if(y==0 ||  (y>0&&pillar[x][y-1]) || (x>0&&bar[x-1][y]) || bar[x][y]){
            return true;
        }
        return false;
    }
}