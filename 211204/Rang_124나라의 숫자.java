class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 3) {
            int a = n % 3;
            n /= 3;
            
            if (a == 0) {
                sb.append("4");
                n--;
            } else if (a == 1) {
                sb.append("1");
            } else if (a == 2) {
                sb.append("2");
            }
        }
        
        if (n == 1) {
            sb.append("1");
        } else if (n == 2) {
            sb.append("2");
        } else if (n == 3) {
            sb.append("4");
        }
        
        return sb.reverse().toString();
    }
}

// 잘 짜인 다른 사람 코드
/*
class Solution {
  public String solution(int n) {
      String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;      // 자리 올림 안 하기 위한 방법, n % 3 = 0 일 때만 자리 수 올림이 안된다.
      }
      return answer;
  }
}
*/
