class Solution {
    public int solution(int[] a) {
        int[] right = new int[a.length];
        
        right[a.length-1] = a.length-1;
        for (int i = a.length-2; i >= 0; i--) {
            if (a[right[i+1]] > a[i])   right[i] = i;
            else                        right[i] = right[i+1];
        }
        
        int answer = 2;
        
        int leftMin = a[0];
        for (int i = 1; i < a.length-1; i++) {
            if (leftMin > a[i-1])
                leftMin = a[i-1];
            
            if (a[i] < leftMin || a[i] < a[right[i+1]])
                answer++;
        }
        
        return answer;
    }
}
