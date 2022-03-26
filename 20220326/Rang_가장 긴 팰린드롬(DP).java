class Solution
{
    public int solution(String s)
    {
        int len = s.length();
        if(len < 2)    return 1;
        
        boolean[][] dp = new boolean[len][len];
        char[] arr = s.toCharArray();
        int max = 1;
        
        // 문자열 길이 1
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        
        // 문자열 길이 2
        for (int i = 0; i < len-1; i++) {
            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
                max = 2;
            }
        }
        
        // 문자열 길이 3 이상
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i <= len - l; i++) {
                int end = i + l - 1;
                if (arr[i] == arr[end] && dp[i+1][end-1] == true) {
                    dp[i][end] = true;
                    max = l;
                }
            }
        }
        
        return max;
    }
}
