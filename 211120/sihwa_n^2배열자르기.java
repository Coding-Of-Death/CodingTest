class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int cnt = 0;
        while(left<=right){
            int min = (int)(left/n)+1;
            answer[cnt++] = (int)Math.max(min, left%n+1);
            left++;
        }
        return answer;
    }
}
