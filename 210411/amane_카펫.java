class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 전체 타일 수
        int total = brown + yellow;
        
        // 가로 세로는 항상 3 이상이어야 함
        // 가로 세로의 곱은 전체 타일 수의 루트2의 값이므로 Math.sqrt(total)
        for(int i = 3; i <= (int)Math.sqrt(total); i++){
            
            int width = i;
            int height = (int) total / width;
            
            // 안쪽 타일의 값은 (가로-2) * (세로-2)의 값과 동일하다
            // 8 * 6의 경우 24 -> (8-2) * (6-2) = 6 * 4 = 24
            // 4 * 3의 경우 2 --> (4-2) * (3-2) = 2
            int inside = (width - 2) * (height - 2);
            
            // 토탈을 가로길이로 나눴을 때 나머지가 생기지 않는 경우
            // && 안쪽 블록 수가 yellow와 동일 할 경우 answer에 대입
            if(total % width == 0 && inside == yellow){
                answer[0] = height;
                answer[1] = width;
            }
            
        }
        
        return answer;
    }
}