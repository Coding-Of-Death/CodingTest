import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        while(i < completion.length)
        {
            if(!participant[i].equals(completion[i])){
                answer = participant[i];
                break;
            }
            i++;
        }
        
        if(!answer.equals(""))
            return answer;
        else
            return participant[participant.length - 1];
        
        
    }
}