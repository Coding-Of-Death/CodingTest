int[][] arr = new int[n][n];
        
        int max = sumOneToN(n);
        
        int k = 1, i = 0, j = 0;
        while (k < max) {
            while (i + 1 < n && k < max && arr[i+1][j] == 0) {
                arr[++i][j] = k++;
            }
            
            while (j + 1 < n && k < max && arr[i][j+1] == 0) {
                arr[i][++j] = ++k;
            }
            
            while (i - 1 > 0 && j - 1 > 0 && k < max && arr[i-1][j-1] == 0) {
                arr[--i][--j] = ++k;
            }
        }
        
        int[] answer = new int[max];
        int index = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < i; j++) {
                answer[index++] = arr[i][j];
            }
        }
        
        return answer;
