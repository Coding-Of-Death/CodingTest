class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        // garbage collector가 많이 필요, 속도가 느림?
        for (int i = 0; i < n; i++) {
            answer[i] = String.format("%" + n + "s", 
                                      Integer.toBinaryString(arr1[i] | arr2[i]));
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i].replace("1", "#");
            answer[i] = answer[i].replace("0", " ");
        }
        
        return answer;
    }
}
