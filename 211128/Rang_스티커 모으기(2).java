class Solution {
    public int solution(int sticker[]) {
        if (sticker.length <= 3) {
            int max = 0;
            for (int i = 0; i < sticker.length; i++) {
                max = Math.max(max, sticker[i]);
            }
            return max;
        }
        
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        
        int len = sticker.length - 1;
        dp1[len] = Math.max(dp1[len-2], dp1[len-1]);
        dp2[len] = Math.max(dp2[len-2] + sticker[len], dp2[len-1]);
        
        return Math.max(dp1[len], dp2[len]);
    }
}
