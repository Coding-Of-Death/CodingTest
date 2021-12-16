class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        if(w%2==0){
            answer = w*h-w*2;
        }else{
            answer = w*h-w;
        }
        return answer;
    }
}
