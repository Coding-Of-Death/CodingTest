package programmers;

public class PG_쿼드압축 {
	static int[] ans;

	static int[] solution(int[][] arr){
		ans = new int[2];
		quad(arr.length, 0, 0, arr);
		return ans;
	}

	static void quad(int n, int x, int y, int[][] arr){
		if(n == 1){
			ans[arr[x][y]]++;
			return;
		}

		if(!isBlock(n, x, y, arr))
			return;

		n /= 2;
		quad(n, x, y, arr);
		quad(n, x + n, y, arr);
		quad(n, x, y + n, arr);
		quad(n, x + n, y + n, arr);
	}

	static boolean isBlock(int n, int x, int y, int[][] arr){
		for(int i = x; i < x + n; i++){
			for(int j = y; j < y + n; j++){
				if(arr[x][y] != arr[i][j])
					return false;
			}
		}

		ans[arr[x][y]]++;
		return true;
	}

}
