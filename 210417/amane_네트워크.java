class Solution {
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 해당 컴퓨터에 방문했는지 여부를 체크
        check = new boolean[n];
        
        for(int i = 0; i < n; i++){
            // 방문하지 않았다면
            // 네트워크의 개수를 +1하고
            // dfs를 통해 네트워크에 연결된 컴퓨터 체크
            if(!check[i]){
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    static void dfs(int node, int[][] computers){
        // 방문한 컴퓨터 체크
        check[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            // 아직 방문하지 않은 컴퓨터이고 컴퓨터가 다른 컴퓨터와 이어져 있다면
            // dfs 재귀로 연결된 컴퓨터와 네트워크 
            if(!check[i] && computers[node][i] == 1)
                dfs(i, computers);
        }
    }
}
