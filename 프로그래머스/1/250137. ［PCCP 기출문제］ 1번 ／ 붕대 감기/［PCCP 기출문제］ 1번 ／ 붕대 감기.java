class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int continueBandage = 0;
        int hp = health;
        
        for(int[] attack:attacks) {
            int attackTime = attack[0];
            int damage = attack[1];
            
            hp += heal(bandage, continueBandage, time, attackTime);
            if(hp>health) hp=health;
            
            hp -= damage;
            continueBandage = 0;
            if(hp<=0) return -1;
            
            time = attackTime + 1;
        }
        
        return hp;
    }
    
    private int heal(int[] bandage, int continueBandage, int time, int attackTime) {
        int hp = 0;
        
        for(int i=time;i<attackTime;i++) {
            hp += bandage[1];
            continueBandage++;
            
            if(continueBandage==bandage[0]) {
                hp += bandage[2];
                continueBandage=0;
            }      
        }
        
        return hp;
    }
    
}