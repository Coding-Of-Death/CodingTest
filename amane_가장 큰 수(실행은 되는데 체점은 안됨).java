class Solution {
    static int d;
    static String answer = "0";
    
    static boolean[] check;
    static int[] per;
    public String solution(int[] numbers) {
        
        d = numbers.length;
        check = new boolean[d];
        per = new int[d];
        
        perm(numbers, per, 0, d, d);
        
        return answer;
    }
    
    static void perm(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) {
            String max = Integer.toString(output[0]);
            for(int i = 1; i < output.length; i++){
                max = max + Integer.toString(output[i]);
            }
                
            if(Integer.parseInt(answer) < Integer.parseInt(max))
                answer = max;

        }

            for (int i=0; i<n; i++) {
            if (check[i] != true) {
                check[i] = true;
                output[depth] = arr[i];
                perm(arr, output, depth + 1, n, r);       
                //output[depth] = 0; // 이 줄은 없어도 됨
                check[i] = false;;
            }
        }
    }
 }