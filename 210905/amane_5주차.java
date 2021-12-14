class Solution {
    public int solution(String word) {
        int answer = 0;
        
        // max = len1 + len2 + len3 + len4 + len5
        int max = 5 + (int)Math.pow(5, 2) + (int)Math.pow(5, 3) + (int)Math.pow(5, 4) + (int)Math.pow(5, 5);
        
        // 전체 개수에서 / 5 + 1하면 각 문자별 시작하는 인덱스를 알 수 있음
        // a는 1부터 e는 782부터 i는 1563부터...
        for(int i = 0; i < word.length(); i++){
            answer += "AEIOU".indexOf(word.charAt(i)) * (max /= 5) + 1;
            //System.out.println(answer);
        }
        
        return answer;
    }
}
