class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            StringBuilder sb = new StringBuilder();
            
            if(numbers[i] % 2 == 0)
                answer[i] = numbers[i] + 1;
            else{
                String bit = Long.toBinaryString(numbers[i]);
                if(!bit.contains("0")){
                    sb.append("10");
                    
                    sb.append(bit.substring(1));
                }
                
                else{
                    int lastIdx = bit.lastIndexOf("0");
                    sb.append(bit.substring(0, lastIdx) + "10" + bit.substring(lastIdx+2));
                }
                
                answer[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        
        return answer;
    }
}
