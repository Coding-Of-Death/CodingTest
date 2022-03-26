class Solution
{
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        
        for (int len = arr.length; len >= 2; len--) {
            for (int i = 0; i + len <= arr.length; i++) {
                boolean flag = true;
                
                for (int j = 0; j < len/2; j++) {
                    if (arr[i + j] != arr[i+len-1-j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    return len;
            }
        }
        
        return 1;
    }
