class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;
        
        for(int i = 0; i < prices.length; i++)
            answer[i] = 0;
        
        for(int i = 0; i < prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] >= prices[i])
                    answer[i]++;
                else{
                    answer[i]++;
                    break;
                }
            }
            //answer[i] = count;
            count = 0;
        }
        return answer;
   }
        
}