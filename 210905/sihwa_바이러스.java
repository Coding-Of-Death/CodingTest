import java.util.*;
public class Main{
    static int node[][];
    static int check[];
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        check[start] = 1;
        q.offer(start);
        int cnt = 0;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i = 1 ; i < node.length; i++){
                if(node[x][i]==1&&check[i]!=1){
                q.offer(i);
                check[i] = 1;
                cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        node = new int[n+1][n+1];
        check = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            node[a][b] = 1;
            node[b][a] = 1;
        }
        bfs(1);
    }
}
