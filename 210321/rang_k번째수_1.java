class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int index = 0; index < commands.length; index++) {
            int[] subArray = 
                getSubArray(array, commands[index][0], commands[index][1]);
            int k = getKthNum(subArray, commands[index][2]);
            answer[index] = k;
        }
        
        return answer;
    }
    
    private int[] getSubArray(int[] array, int start, int end) {
        int[] subArray = new int[end - start + 1];
        
        for (int i = 0; i < subArray.length ; i++) {
            subArray[i] = array[start - 1 + i];
        }
        
        sort(subArray);
        
        return subArray;
    }
    
    private void sort(int[] array) {
        int swap;
        
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }
    
    private int getKthNum(int[] array, int k) {
        return array[k - 1];
    }
}