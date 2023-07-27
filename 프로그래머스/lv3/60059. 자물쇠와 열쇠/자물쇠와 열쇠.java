class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length + (key.length-1) * 2;
        int keySize = key.length;
        int lockSize = lock.length;
        
        for(int x=0; x<=N-key.length;x++){
            for(int y=0; y<=N-key.length;y++){
                for(int r=0;r<4;r++){
                    int[][] newLock = createNewLock(key, lock, x, y);
                    boolean isFinish = checkFinish(newLock, keySize-1, lockSize);
                    
                    if(isFinish){
                       return true;
                    }
                    key = rotateKey(key);
                }
            }
        }
        
        return false;
    }
    
    int[][] rotateKey(int[][] key){
        int N=key.length;
        int[][] newKey = new int[N][N];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newKey[j][N-1-i]=key[i][j];
            }
        }
        
        return newKey;
    }
    
    boolean checkFinish(int[][] newLock, int start, int size){
        for(int i=start;i<start+size;i++){
            for(int j=start;j<start+size;j++){
                if(newLock[i][j]!=1){
                    return false;
                }
            }
        }
        return true;
    }
    
    int[][] createNewLock(int[][] key, int[][] lock, int x,int y){
        int SIZE = lock.length + (key.length-1) * 2;
        int[][] newLock = new int[SIZE][SIZE];
        int N = key.length;
        
        for(int i=x;i<x+N;i++){
            for(int j=y;j<y+N;j++){
                newLock[i][j]=key[i-x][j-y];
            }
        }
        
        N--;
        for(int i=N; i<N+lock.length; i++){
            for(int j=N; j<N+lock.length; j++){
                newLock[i][j]+=lock[i-N][j-N];
            }
        }
        
        return newLock;
    }
}