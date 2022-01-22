class Solution {
    public String solution(String s, int n) {
        String small  = "abcdefghijklmnopqrstuvwxyz";
        String big    = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer += ' ';
            } else if (small.indexOf(c) > -1) {
                int idx = (small.indexOf(c) + n) % 26;
                answer += small.charAt(idx);
            } else if (big.indexOf(c) > -1) {
                int idx = (big.indexOf(c) + n) % 26;
                answer += big.charAt(idx);
            }
        }
        
        return answer;
    }
}
