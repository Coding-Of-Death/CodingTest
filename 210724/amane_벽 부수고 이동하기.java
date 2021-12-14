import java.util.*;

public class Main{
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][][] check;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        map = new int[n+1][m+1];
        check = new boolean[n+1][m+1][2];
        
        for(int i = 1; i <= n; i++){
            String tmp = sc.next();
            
            for(int j = 1; j <= m; j++){
                map[i][j] = Character.getNumericValue(tmp.charAt(j - 1));
            }
        }
        
        bfs(1, 1);
        
    }
    
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y, 1, 0});
        check[x][y][0] = true;
        //check[x][y][1] = true;
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            
            if(point[0] == n && point[1] == m){
                System.out.println(point[2]);
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int mx = point[0] + dx[i];
                int my = point[1] + dy[i];
                
                if(mx > 0 && mx <= n && my > 0 && my <= m){
                    if(map[mx][my] == 1){
                        if(point[3] == 0 && !check[mx][my][1]){
                            q.offer(new int[]{mx, my, point[2] + 1, 1});
                            check[mx][my][1] = true;
                        }
                    } else{
                        if(!check[mx][my][point[3]]){
                            q.offer(new int[]{mx, my, point[2] + 1, point[3]});
                            check[mx][my][point[3]] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
