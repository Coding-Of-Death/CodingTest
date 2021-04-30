class Solution {
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] studentClothes = new int[n];
        
        for (int i = 0; i < n; i++)
            studentClothes[i] = 1;
        
        for (int i : reserve)
            studentClothes[i-1]++;
        
        for (int i : lost)
            studentClothes[i-1]--;
        
        for (int i = 0; i < n; i++) {
            if (studentClothes[i] > 1) {
                if (i-1 >= 0 && studentClothes[i-1] == 0) {
                    studentClothes[i-1]++;
                    studentClothes[i]--;
                } else if (i+1 < n && studentClothes[i+1] == 0) {
                    studentClothes[i+1]++;
                    studentClothes[i]--;
                }
            }
        }
        
        for (int student : studentClothes) {
            if (student != 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
