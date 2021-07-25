class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                answer[i] = num + 1 + ((num^(num + 1)) >>> 2);
                // answer[i] = num + 1 +(num^(num + 1)) / 4;
            }
          // if 문으로 홀, 짝 나누지 않고 answer[i] = num + 1 + ((num^(num + 1)) >>> 2); 로 처리 가능
        }
        
        return answer;
    }
}
