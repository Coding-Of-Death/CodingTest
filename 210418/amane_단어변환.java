class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = words.length + 1;
        
        // 단어의 수 만큼 반복
        for(int i = 0; i < words.length; i++){
            boolean[] check = new boolean[words.length];
            
            if(isDiffOne(begin, words[i])){
                // 현재 횟수와 새로 dfs하여 구한 횟수 중 가장 작은 수를 저장
                answer = Math.min(answer, dfs(i, words[i], target, words, check, 1));
            }
        }
        
        // 만약 words의 길이보다 길면 words안에 없다는 target이 없어서
        // answer의 값이 변하지 않았다는 것이므로 0 리턴
        if(answer == words.length + 1)
            return 0;
      
        // 아니면 answer 리턴
        return answer;
    }
    
  
    /*
    
    isDiffOne(바꿀 단어, 비교하는 단어)
    
    단어의 철자를 비교하며 철자가 1글자만 다르면 true를 반환
    2글자 이상 다를 경우 false반환
    
    */
  
    static boolean isDiffOne(String begin, String word){
        int count = 0;
        for(int i = 0; i < begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i))
                count++;
        }
        if(count == 1)
            return true;
        else
            return false;
    }
    
    /*
    
    dfs(몇번째인지, 바꿀 단어, 최종 목표 단어, 단어 배열, 변경했는지 체크하는 배열, 변경 횟수)
    
    begin이 target과 같다면 이제 더이상 변경할 필요가 없으므로 변경 횟수(count) 리턴
    현재 위치의 단어를 다녀간 적이 있어도 변경 횟수 리턴
    
    아니라면
    현재 위치의 단어를 다녀간 적이 있다고 변경(true)
    
    words의 크기만큼 반복하며
    그 중에서 현재위치가 아니고 /// 비교대상과 철자가 하나만 다르고 /// 다녀간 적이 없다면
    dfs를 재귀하여 ans에 저장
    ans 리턴
    
    */
    static int dfs(int idx, String begin, String target, String[] words, boolean[] check, int count){
        if(begin.equals(target))
            return count;
        if(check[idx])
            return count;
        
        check[idx] = true;
        int ans = 0;
        
        for(int i = 0; i < words.length; i++){
            if(idx != i && isDiffOne(begin, words[i]) && !check[i]){
                ans = dfs(i, words[i], target, words, check, count+1);
            }
        }
        
        return ans;
    }
}
