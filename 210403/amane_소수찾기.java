import java.util.*;

public class Main{
    
	static int len = 0;
    static boolean[] check;
    
    static int solution(String numbers) {
        len = numbers.length();
	    char[] cha = new char[len];
        check = new boolean[len];
        ArrayList<Integer> arr = new ArrayList<Integer>();
	    
        // 문자열을 쪼개서 배열에 저장
	    for(int i = 0; i < numbers.length(); i++)
	        cha[i] = numbers.charAt(i);
	    
	    // 조합할 수 있는 경우의 수를 전부 체크
        for(int i = 0; i < numbers.length(); i++){
            char[] output = new char[i+1];
	        perm(cha, output, arr, 0, i+1);
	    }
	    
	    return arr.size();
    }
    
    /*
     * cha 		= 문자열을 문자로 쪼개 저장한 배열
     * output 	= 조합을 통해 뽑은 문자 배열
     * arr 		= 소수인 숫자들을 저장하는 ArrayList
     * depth	= dfs에서 현재 깊이
     * r 		= cha에서 뽑을 문자의 개수
     */
    static void perm(char[] cha, char[] output, ArrayList<Integer> arr, int depth, int r) {
        
        String str = "";
        int num;
        
        // 현재 깊이가 r과 같아지면
        if (depth == r) {
        	// char를 문자열로 조합
            for(int i = 0; i < r; i++) {
            	str += output[i];
            }
            
            // 조합한 문자열을 int로 변환
            num = Integer.parseInt(str);
            
            
            // 조합한 숫자가 소수이고 arr에 추가되어 있지 않다면
            // num 추가
            if(isPrime(num) && !(arr.contains(num)))
            	arr.add(num);
            
            return;
        }
       
        // dfs를 통해 가능한 조합 찾기
        for (int i = 0; i < len; i++) {
            if (check[i] != true) {
                check[i] = true;
                output[depth] = cha[i];
                perm(cha, output, arr, depth + 1, r);
                check[i] = false;;
            }
        }
    }
     
    // 소수 찾기 함수
    static boolean isPrime(int ans){
        int sqrt = (int)Math.sqrt(ans);
        
        if(ans == 2)
            return true;
        
        if(ans % 2 == 0 || ans == 1)
            return false;
        
        for(int i = 3; i <= sqrt; i+=2)
        {
            if(ans%i == 0)
                return false;
        }
        return true;
    }
}