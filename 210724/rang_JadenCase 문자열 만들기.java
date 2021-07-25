class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if ( i == 0 || arr[i-1] == ' ') {
                if (Character.isAlphabetic(arr[i])) {
                    arr[i] = Character.toUpperCase(arr[i]);
                }
            } else {
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for (char a : arr) {
            sb.append(a);
        }
        
        return sb.toString();
    }
}
