import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!checked[i]) {
                answer++;
                checked[i] = true;
                queue.add(i);
            }
            
            while (!queue.isEmpty()) {
                int c = queue.remove();
                
                for (int j = 0; j < n; j++) {
                    if (!checked[j] && computers[c][j] == 1) {
                        checked[j] = true;
                        queue.add(j);
                    }
                }
            }  
        }
        
        return answer;
    }
}
