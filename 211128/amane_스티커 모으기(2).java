class Solution {
    public int solution(int stickers[]) {
        int[] dp1 = new int[stickers.length];
        int[] dp2 = new int[stickers.length];
        
        if(stickers.length == 2)
            return Math.max(stickers[0], stickers[1]);
        
        if(stickers.length == 1)
        	return stickers[0];
        
        dp1[0] = stickers[0];
        dp1[1] = stickers[0];
       
        dp2[0] = 0;
        dp2[1] = stickers[1];
       
        for(int i = 2; i < stickers.length; i++) {
        	dp1[i] = Math.max(dp1[i - 2] + stickers[i], dp1[i - 1]);
        	dp2[i] = Math.max(dp2[i - 2] + stickers[i], dp2[i - 1]);
    	   
        }
        
        return Math.max(dp1[stickers.length - 2], dp2[stickers.length - 1]);
    }
}
