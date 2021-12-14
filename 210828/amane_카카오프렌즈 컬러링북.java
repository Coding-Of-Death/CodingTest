class Solution {
    static boolean[][] check;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        check = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(picture[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !check[i][j]){
                    numberOfArea++;
                    dfs(i, j, picture);
                }
                
                maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                count = 0;
                    
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    static void dfs(int x, int y, int[][] picture){
        check[x][y] = true;
        count++;
        
        for(int i = 0; i < 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if(mx < 0 || my < 0 || mx >= picture.length || my >= picture[0].length)
                continue;
            
            if(picture[x][y] == picture[mx][my] && !check[mx][my])
                dfs(mx, my, picture);
        }
        
    }
}
