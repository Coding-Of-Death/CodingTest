import java.util.*;


class Solution {
    public int solution(int n, int[][] computers) {
        int count, answer = 0;
        boolean[] checked = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    queue.offer(j);
                }
            }
            
            count = 0;
            
            while(!queue.isEmpty()) {
                int j = queue.poll();
                
                if(!checked[j]) {
                    checked[j] = true;
                    count++;
                    
                    for (int k = 0; k < n; k++) {
                        if (computers[j][k] == 1) {
                            queue.offer(k);
                        }
                    }
                }
            }
            
            if (count > 0)
                answer++;
        }
        
        return answer;
    }
}
