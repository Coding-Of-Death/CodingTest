class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] list = dartResult.toCharArray();
        int[] score = new int[3];
        int idx = -1;
        
        for(int i = 0; i < list.length; i++){
            
            if(list[i] >= '0' && list[i] <= '9'){                
                idx++;
                
                if(list[i] == '1' && list[i+1] == '0'){
                    i++;
                    score[idx] = 10;
                    
                } else{
                    score[idx] = list[i] - '0';
                }
            } else if (list[i] == 'D'){
                score[idx] = (int) Math.pow(score[idx], 2);
                
            } else if (list[i] == 'T'){
                score[idx] = (int) Math.pow(score[idx], 3);
                
            } else if (list[i] == '*'){
                if(idx != 0)
                    score[idx - 1] *= 2;
                
                score[idx] *= 2;
                
            } else if(list[i] == '#'){
                score[idx] *= -1;
                
            }
        }
        
        for(int i = 0; i < 3; i++){
            answer += score[i];
        }
        
        return answer;
    }
}
