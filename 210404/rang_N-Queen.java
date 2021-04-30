/*
- 1행 1퀸의 규칙
   :   n개의 인덱스(행)을 가지는 열 배열을 만든다. int[] col = new int[n];
       각 인덱스에는 1부터 n까지의 숫자만 넣을 수 있다.

- 이전 퀸들의 열 ≠ 현재 퀸의 열
- N개의 퀸이 같은 대각선에 존재하면 안된다.
    :  Math.abs(이전 퀸들의 행 - 현재 퀸의 행) != Math.abs(이전 퀸들의 열 - 현재 퀸의 열)
*/

import java.util.*;

public class Main {
	static int[] col;
	static int	 count = 0;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		col = new int[n];
		
		searchNqueen(n, 0);
		
		System.out.println(count);
	}
	
	static void searchNqueen(int n, int row) {
		if (row == n) {
			count++;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			col[row] = i;
			if (isCheckedQueen(row)) {
				searchNqueen(n, row+1);
			}
		}
	}
	
	static boolean isCheckedQueen(int currentRow) {
		boolean result = true;
		
		for(int row = 0; row < currentRow; row++) {
			if (col[row] == col[currentRow]) {
				result = false;
				break;
			}
			if (Math.abs(row - currentRow) == Math.abs(col[row] - col[currentRow])) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
}
