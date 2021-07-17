class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        char[] dir = dirs.toCharArray();
        boolean[][][][] map = new boolean[11][11][11][11];
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        int nextX = 5;
        int nextY = 5;
        
        int idx = 0;
        
        for(int i = 0; i < dir.length; i++){
            int x = nextX;
            int y = nextY;
            
            switch(dir[i]){
                case 'U':
                    idx = 0;
                    break;
                    
                case 'D':
                    idx = 1;
                    break;
                    
                case 'R':
                    idx = 2;
                    break;
                    
                case 'L':
                    idx = 3;
                    break;
            }
            
            //System.out.println(nextX + " " + nextY);
            
            nextX += dx[idx];
            nextY += dy[idx];
            
            if(nextX < 0 || nextX > 10 || nextY < 0 || nextY > 10){
                nextX -= dx[idx];
                nextY -= dy[idx];
                continue;
            }
            
            if(!map[x][y][nextX][nextY] || !map[nextX][nextY][x][y]){
                map[x][y][nextX][nextY] = true;
                map[nextX][nextY][x][y] = true;
                answer++;
            }
            
        }
        return answer;
    }
}
