import java.util.*;
public class Main{
    static int node[][];
    static int check[];
    static Queue<Integer> q = new LinkedList<>();
    
    static void dfs(int x){
        if(check[x]==1) return;
        
        check[x] = 1;
        System.out.print(x+" ");
        for(int i = 1; i < node.length; i++){
            if(node[x][i] == 1){
                dfs(i);
            }
        }
    }
    static void bfs(int x){
        q.offer(x);
        check[x] = 1;
        while(!q.isEmpty()){
            x = q.poll();
            System.out.print(x + " ");
            for(int i = 1; i<node.length;i++){
                if(check[i]!=1&&node[x][i]==1){
                    q.offer(i);
                    check[i] = 1;
                }
            }
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        
        node = new int[n+1][n+1];
        check = new int[n+1];
        
        for(int i = 0 ; i  < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            node[a][b] = 1;
            node[b][a] = 1;
        }
    dfs(v);
    Arrays.fill(check,0);
    System.out.println("");
    bfs(v);
    }
}
