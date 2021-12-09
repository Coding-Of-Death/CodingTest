import java.util.*;


public class Main {
    static int N, M, K;
    static int max;
    static int[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System. in);
        
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        map = new int[N][M];
        for (int i = 0; i < K; i++) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            map[r-1][c-1] = 1;
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                     max = Math.max(max, bfs(i, j));
            }
        }

        System.out.println(max);

        scan.close();
    }


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static int bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        int size = 1;

        queue.add(x);
        queue.add(y);
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            int cX = queue.remove();
            int cY = queue.remove();

            for (int i = 0; i < dx.length; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M)
                    continue;

                if (map[nX][nY] == 1) {
                    queue.add(nX);
                    queue.add(nY);
                    map[nX][nY] = 0;
                    size++;
                }
            }
         }
         return size;
    }
}
