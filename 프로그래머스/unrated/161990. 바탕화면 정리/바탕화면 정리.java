class Solution {
    //가장 위쪽 인덱스, 가장 왼쪽 인덱스, 가장 오른쪽 인덱스, 가장 아래쪽 인덱스
    public int[] solution(String[] wallpaper) {
        int up=50,down=0,left=50,right=0;
        
        int N=wallpaper.length;
        int M=wallpaper[0].length();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(wallpaper[i].charAt(j)=='#'){
                    up=Math.min(up,i);
                    left=Math.min(left,j);
                    down=Math.max(down,i+1);
                    right=Math.max(right,j+1);
                }
            }
        }
        
        return new int[]{up,left,down,right};
    }
}