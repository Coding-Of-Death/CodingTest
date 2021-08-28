import java.util.*;


class Solution {
    int[][] p;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        p = clone(picture, m, n);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i,j));
                }
            }
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    int[][] clone(int[][] arr, int m, int n) {
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            result[i] = arr[i].clone();
        }
        
        return result;
    }
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        
        int color = p[x][y];
        p[x][y] = 0;
        int size = 1;
        queue.add(x); queue.add(y);
        
        while (!queue.isEmpty()) {
            int pX = queue.remove();
            int pY = queue.remove();
            
            for (int i = 0; i < dx.length; i++) {
                int nX = pX + dx[i];
                int nY = pY + dy[i];
                if (check(nX, nY, color)) {
                    size++;
                    p[nX][nY] = 0;
                    queue.add(nX); queue.add(nY);
                }
            }
        }
        return size;
    }
    
    boolean check(int x, int y, int color) {
        if (x < 0 || x >= p.length)    return false;
        if (y < 0 || y >= p[0].length) return false;
        if (p[x][y] != color) return false;
        return true;
    }
}
