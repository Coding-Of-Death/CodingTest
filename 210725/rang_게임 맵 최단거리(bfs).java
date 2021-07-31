import java.util.*;


class Point {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return  bfs(maps);
        //int answer = dfs(maps, n-1, m-1);
        //return answer > 1 ? answer : -1;
    }
    
    public int bfs(int[][] maps) {
        int[][] visited = new int[n][m];
        init(visited);
        
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0));
        visited[0][0] = 1;
        
        while (!que.isEmpty()) {
            Point p = que.remove();
            
            for (int i = 0; i < dx.length; i++) {
                int next_x = p.x + dx[i];
                int next_y = p.y + dy[i];
                
                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m)
                    continue;
                
                if (maps[next_x][next_y] == 1 && visited[next_x][next_y] == -1) {
                    visited[next_x][next_y] = visited[p.x][p.y] + 1;
                    que.add(new Point(next_x, next_y));
                }
            }
        }
        
        return visited[n-1][m-1];
    }
    
    public void init(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = -1;
            }
        }
    }
}
