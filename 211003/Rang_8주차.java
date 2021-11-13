class Solution {
    public int solution(int[][] sizes) {
        int longLen = 0, shortLen = 0;
        
        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                longLen = Math.max(longLen, size[0]);
                shortLen = Math.max(shortLen, size[1]);
            } else {
                longLen = Math.max(longLen, size[1]);
                shortLen = Math.max(shortLen, size[0]);
            }
        }
        
        return longLen * shortLen;
    }
}
