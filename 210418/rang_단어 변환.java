import java.util.*;

class Solution {
    boolean[] check;
    int answer = Integer.MAX_VALUE;
    
    
    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        
        // target이 words에 포함되어 있는지 확인
        // java7 이하
        //if (!Arrays.asList(words).contains(target)) {
        // java8 이상
        if (!Arrays.stream(words).anyMatch(target::equals)) {
            return 0;
        }
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!check[i] && isDifferOne(begin, words[i])) {
                check[i] = true;
                dfs(words[i], target, words, count+1);
                check[i] = false;
            }
        }
    }
    
    boolean isDifferOne(String s1, String s2) {
        int differ = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                differ++;
            }
        }
        
        if (differ == 1) {
            return true;
        }
        return false;
    }
}
