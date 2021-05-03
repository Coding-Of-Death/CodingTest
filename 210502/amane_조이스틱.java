class Solution {
    public int solution(String name) {
        int answer = 0;
        int min = name.length() - 1; // ?AAAAAA의 경우
        
        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);
            
            int j = i + 1;
        
            while(j < name.length() && name.charAt(j) == 'A'){
                j++;
            }
            
            // DSAAAD --> 6 - 3 + 2 + 2 = 7
            // 전체 길이 - 연속되는 A의 개수 + 다시 처음으로 돌아감 + 다시 현재 위치로 돌아옴
            // 다음 문자를 가리킴
            // 뒤에서 부터 바꿀래? 앞에서 부터 바꿀래의 차이 비교
            min = Math.min(min, name.length() - j + i + i);
        }
        answer += min;
        
        return answer;
    }
}
