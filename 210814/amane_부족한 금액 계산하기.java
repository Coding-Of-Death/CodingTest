class Solution {
    public long solution(int price, int money, int count) {
        long answer = (long) money;
        
        for(int i = 1; i <= count; i++){
            money -= (long) price * i;
        }
        
        return money <= 0 ? Math.abs((long) money) : 0;
    }
}
