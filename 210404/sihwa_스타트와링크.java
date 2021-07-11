import java.util.*;
public class Main{
    static int n;
    static int[][] map;
    static boolean[] visited;
    
    static int Min = Integer.MAX_VALUE;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        map = new int[n][n];
        visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        combi(0,0);
        System.out.println(Min);
    }
    static void combi(int idx, int count){
        if(count == n/2){
            diff();
            return;
        }
        for(int i = idx; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                combi(i+1, count+1);
                visited[i] = false;
            }
        }
    }
    
    static void diff(){
        int team_start = 0;
        int team_link = 0;
        
        for(int i = 0; i < n-1; i++){
            for(int j = i+1 ; j <n; j++){
                if(visited[i]==true&&visited[j]==true){
                    team_start += map[i][j];
                    team_start += map[j][i];
                }
                else if(visited[i]==false && visited[j]==false){
                    team_link += map[i][j];
                    team_link += map[j][i];
                }
            }
        }
        int val = Math.abs(team_start - team_link);
        
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        Min = Math.min(val,Min);
    }
}
