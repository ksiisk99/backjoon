class Solution {
    static final int[] DISCOUNT={10,20,30,40};
    static int[] flag;
    static int subscribers;
    static int sales;

    void recursive(int cnt, int[][] users, int[] emoticons){
        if(cnt==emoticons.length){
            calc(users,emoticons);
            return;
        }
        for(int i=0;i<4;i++){
            flag[cnt]=i;
            recursive(cnt+1,users,emoticons);
        }
    }

    void calc(int[][] users, int[] emoticons){
        int subscribers=0;
        int sales=0;
        int[] discountPrices=calculateDiscount(emoticons);

        for(int i=0;i<users.length;i++){
            int price=0;
            for(int j=0;j<flag.length;j++){
                if(DISCOUNT[flag[j]]>=users[i][0]){
                    price+=discountPrices[j];
                }
            }
            if(price>=users[i][1]){
                subscribers++;
            }else{
                sales+=price;
            }
        }

        if(this.subscribers<subscribers){
            this.subscribers=subscribers;
            this.sales=sales;
        }else if(this.subscribers==subscribers && this.sales<sales){
            this.sales=sales;
        }
    }

    int[] calculateDiscount(int[] emoticons){
        int[] discountPrices=new int[flag.length];
        for(int i=0;i<flag.length;i++){
            discountPrices[i]=emoticons[i]-(emoticons[i]*DISCOUNT[flag[i]]/100);
        }
        return discountPrices;
    }

    public int[] solution(int[][] users, int[] emoticons) {
        flag=new int[emoticons.length];
        recursive(0,users,emoticons);
        return new int[]{subscribers,sales};
    }
}