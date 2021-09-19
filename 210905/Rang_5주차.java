class Solution {
    public int solution(String word) {
        int answer = 0;
        
        int caseNum = 5 + (int) Math.pow(5,2) + (int) Math.pow(5,3) + (int) Math.pow(5,4) + (int) Math.pow(5,5);
        
        for (String s : word.split("")) {
            answer += "AEIOU".indexOf(s) * (caseNum /= 5) + 1;
        }
        
        return answer;
    }
}
