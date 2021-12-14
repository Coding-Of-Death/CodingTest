class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' ')
                sb.append(" ");
            else if(s.charAt(i - 1) == ' ')
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
        }
        
        answer = sb.toString();
        
        return answer;
    }
}
