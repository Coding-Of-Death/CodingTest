import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String pre = "";
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++){
            pre = phone_book[i];
            
            //어차피 정렬이라 이 뒤에 것의 접두사가 되면 끝임
            if(phone_book[i+1].indexOf(pre) == 0)
                return false;
        }
        
        /*
        효율성에서 두개 죽음
        for(int i = 0; i < phone_book.length; i++){
            pre = phone_book[i];
            for(int j = 0; j < phone_book.length; j++){
                if (i == j) continue;
                
                if(phone_book[j].indexOf(pre) == 0){
                    return false;
                    
                    //answer = false 는 효율성에서 죽음
                }
            }
        }
        */
        return answer;
    }
}