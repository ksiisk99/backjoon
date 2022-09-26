import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        long ans=LongStream.range(1,count+1)
            .map(i->i*price)
            .sum()-money;
        return ans>0?ans:0;
    }
}