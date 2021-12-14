import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] check;
    static int n, m;
    
    public static class Node{
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        check = new boolean[n][m];
        
        return bfs(0, 0, maps);
    }
    
    static int bfs(int x, int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        check[x][y] = true;
        
        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.x == n - 1 && tmp.y == m - 1)
                return tmp.cost;
            
            for(int i = 0; i < 4; i++){
                int mx = tmp.x + dx[i];
                int my = tmp.y + dy[i];

                if(mx >= 0 && mx < n && my >= 0 && my < m){
                    if(maps[mx][my] == 1 && !check[mx][my]){
                        check[mx][my] = true;
                        q.offer(new Node(mx, my, tmp.cost + 1));
                    }
                }
            }
        }
        return -1;
    }
}
