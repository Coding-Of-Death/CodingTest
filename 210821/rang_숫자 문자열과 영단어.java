class Solution {
    public int solution(String s) {
        String[] enNums = {"zero", "one", "two", "three", "four", 
                           "five", "six", "seven", "eight", "nine"};
        
        String tmp = new String(s);
        for (int i = 0; i < enNums.length; i++) {
            tmp = tmp.replace(enNums[i], "" + i);
        }
        
        return Integer.parseInt(tmp);
    }
}
