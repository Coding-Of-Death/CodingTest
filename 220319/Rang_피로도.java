class Solution {
    int answer = 0;
    boolean[] checked;
    
    public int solution(int k, int[][] dungeons) {
        checked = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    void dfs(int count, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!checked[i] && k >= dungeons[i][0]) {
                checked[i] = true;
                dfs(count+1, k-dungeons[i][1], dungeons);
                checked[i] = false;
            }
        }
        
        answer = Math.max(answer, count);
    }
}
