import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    
    public int solution(int n, int[][] wires) {
        int answer = 101;
        list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < wires.length; i++){
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }
        
        for(int[] w : wires){
            answer = Math.min(answer, bfs(w[0], w[1]));
        }
        
        return answer;
    }
    
    static int bfs(int start, int pass){
        boolean[] check = new boolean[list.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        // cnt = A 송전탑 개수
        int cnt = 0;
        int now;
        
        while(!q.isEmpty()){
            // 송전탑 개수++
            cnt++;
            now = q.poll();
            check[now] = true;
            
            for(int tmp : list.get(now)){
                if(tmp == pass || check[tmp])
                    continue;
                q.add(tmp);
            }
        }
        
        // 전체 송전탑 - A 전력망 송전탑 = B 전력망
        // Math.abs(B 전력망 - A 전력망 == 전체 - A 전력망 - A 전력망)
        return Math.abs(list.size() - 1 - cnt - cnt);
    }
}
