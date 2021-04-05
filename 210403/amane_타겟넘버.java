class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int start){
        if(start == numbers.length){
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                sum += numbers[i];
            }
            if(sum == target)
                answer++;
        }
        
        else{
            numbers[start] *= 1;
            dfs(numbers, target, start+1);
            
            numbers[start] *= -1;
            dfs(numbers, target, start+1);
        }
    }
}