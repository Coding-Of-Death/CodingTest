import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int k = 0; k < T; k++){
            int v = sc.nextInt();
            int e = sc.nextInt();
            
            ArrayList<ArrayList<Integer>> a = new ArrayList<>();
            
            for(int i = 0; i < v; i++)
                a.add(new ArrayList<>());
            
            for(int i = 0; i < e; i++){
                int node1 = sc.nextInt();
                int node2 = sc.nextInt();
                
                a.get(node1 - 1).add(node2 - 1);
                a.get(node2 - 1).add(node1 - 1);
            }
            
            int[] color = new int[v];
            
            boolean flag = true;
            
            for(int i = 0; i < v; i++){
                if(color[i] == 0)
                    dfs(a, color, i, 1);
            }
            
            for(int i = 0; i < v; i++){
                for(int j : a.get(i))
                    if(color[i] == color[j])
                        flag = false;
            }
            
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> a, int[] color, int x, int c){
        color[x] = c;
        for(int i : a.get(x))
            if(color[i] == 0)
                dfs(a, color, i, 3 - c);
    }
}
