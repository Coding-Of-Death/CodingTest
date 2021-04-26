class Solution {
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!check[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    static void dfs(int node, int[][] computers){
        check[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(!check[i] && computers[node][i] == 1)
                dfs(i, computers);
        }
    }
}