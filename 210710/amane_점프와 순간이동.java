public class Solution {
    public int solution(int n) {
        int ans = 1;    // 어차피 한 칸은 이동해야 함

        while(n > 1){
            if(n % 2 == 1) ans++;   // 홀수의 경우, 한 칸을 점프하기 위해 건전지 사용해야 함
            n /= 2;     // 순간이동은 건전지 사용 X
        }

        return ans;
    }
}
