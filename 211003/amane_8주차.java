class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int w = 0;
        int h = 0;
        
        for(int i = 0; i < sizes.length; i++){
            // 가로길이가 더 길 경우
            if(sizes[i][0] >= sizes[i][1]){
                w = Math.max(sizes[i][0], w);
                h = Math.max(sizes[i][1], h);
            }
            
            // 세로길이가 더 길 경우
            else{
                w = Math.max(sizes[i][1], w);
                h = Math.max(sizes[i][0], h);
            }
        }
        
        answer = w * h;
        
        return answer;
    }
}
