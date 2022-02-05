class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        char[] word = new char[(t + 1) * m + 1];
        
        int num = 0, indx = 1;
        boolean flag = false;
        while(true) {
            String num_change = notation(num++, n);
            for (int i = 0; i < num_change.length(); i++) {
                word[indx++] = num_change.charAt(i);
                if (indx == word.length) {
                    flag = true;
                    break;
                }
            }
            
            if (flag)   break;
        }
        
        System.out.println(word);
        
        for (int i = 0; i < t; i++) {
            answer += word[i * m + p];
        }
        
        return answer;
    }
	
	String notation(int dec, int n) {
		String result = "";
		
		if (dec == 0) {
			return "0";
		}
		
		while (dec > 0) {
			int remainder = dec % n;
			
			if (remainder > 9) {
				result = (char)(remainder + 55) + result;
			} else {
				result = remainder + result;
			}
			
			dec /= n;
		}
		
		return result;
	}
}
