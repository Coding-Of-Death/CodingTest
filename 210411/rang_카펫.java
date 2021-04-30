class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int garo;
        int sero;
        
        // 노란색 먼저 놓기 yellow
        // 노란색과 닿는 갈색 + 4
        for (int y = 1; y <= Math.sqrt(yellow); y++) {
            if (yellow % y == 0) {
                garo = yellow / y;
                sero = y;
                if (((garo + sero) * 2) + 4 == brown) {
                    answer[0] = garo + 2;
                    answer[1] = sero + 2;
                }
            }
        }
        
        
        return answer;
    }
}
