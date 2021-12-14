import java.util.*;

public class Main{
	static int n;
	static ArrayList<Integer>[] list;
	static int[] parent;
	static boolean[] check;
	
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        list = new ArrayList[n + 1];
        parent = new int[n + 1];
        check = new boolean[n + 1];
        
        for(int i = 1; i <= n; i++) {
        	list[i] = new ArrayList<Integer>();
        }
        
        for(int i = 1; i < n; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	list[a].add(b);
        	list[b].add(a);
        }
        
        for(int i = 1; i <= n; i++) {
        	if(!check[i])
        		dfs(i);
        }
        
        for(int i = 2; i <= n; i++) {
        	System.out.println(parent[i]);
        }
    }
    
    static void dfs(int k) {
    	if(check[k])
    		return;
    	
    	check[k] = true;
    	
    	for(int num : list[k]) {
    		if(!check[num]) {
    			parent[num] = k;
    			dfs(num);
    		}
    	}
    }
}
