class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] board=new int[11][11];
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        boolean[][][][] visit=new boolean[11][11][11][11];
        int x=5;
        int y=5;
        
        for(int i=0;i<dirs.length();i++){
            int direct=0;
            switch(dirs.charAt(i)){
                case 'U':
                    direct=0;
                    break;
                case 'D':
                    direct=1;
                    break;
                case 'R':
                    direct=2;
                    break;
                case 'L':
                    direct=3;
                    break;
            }
            int nx=x+dx[direct];
            int ny=y+dy[direct];
            
            if(nx<0 || ny<0 || nx>=11 || ny>=11)continue;
            if(!visit[nx][ny][x][y])answer++;
            visit[nx][ny][x][y]=true;
            visit[x][y][nx][ny]=true;
            x=nx;
            y=ny;
        }
        return answer;
    }
}