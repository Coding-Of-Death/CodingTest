import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
            }
        }
        
        /*
        // 시간초과 : 2중 for문을 쓰면 안된다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].trim().startsWith(phone_book[i].trim())) {
                    answer = false;
                    break;
                }
                if (phone_book[i].trim().startsWith(phone_book[j].trim())) {
                    answer = false;
                    break;
                }
            }
        }
        */
        
        
        return answer;
    }
}
