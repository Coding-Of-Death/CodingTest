class Solution {
    public int[] solution(int n, long left, long right) {
        System.out.println(left / n);
        
        int[] answer = new int[(int)(right - left + 1)];
        int index = 0;
        
        while (left <= right) {
            answer[index++] = (int) Math.max(Math.floor(left / n), left++ % n) + 1;
        }
        
        return answer;
    }
}
