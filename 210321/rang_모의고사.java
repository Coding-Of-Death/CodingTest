class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i%5])    score[0]++;
            if (answers[i] == answer2[i%8])    score[1]++;
            if (answers[i] == answer3[i%10])    score[2]++;
        }
        
        int[] temp = new int[3];
        
        int index = 0, max = score[0];
        temp[index] = 1;
        for (int i = 1; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
                temp[index] = i + 1;
            } else if (max == score[i]) {
                temp[++index] = i + 1;
            }
        }
        
        answer = new int[index + 1];
        for (int i = 0; i < index + 1; i++) {
            answer[i] = temp[i];
        }
        
        return answer;
    }
}