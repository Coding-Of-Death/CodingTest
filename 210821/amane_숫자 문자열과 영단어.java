class Solution {
    public int solution(String s) {
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++){
            if(s.indexOf(num[i]) == -1)
                continue;
            
            s = s.replace(num[i], number[i]);
            System.out.println(s);
        }
        
        return Integer.parseInt(s);
    }
}
