class Solution {
    public long solution(int price, int money, int count) {
        long answer = (long) money;
        
        for(int i = 1; i <= count; i++){
            long p = (long) price * i;
            answer -= p;
        }
        
        return answer <= 0 ? Math.abs(answer) : 0;
    }
}
