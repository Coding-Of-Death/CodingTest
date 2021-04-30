/*
DFS 방식

※주의할 점※
1. 종결조건
    1. 배추가 없는 지점
    2. 시작부터 배추가 없어서 종결조건에 들어가지 않게 해야
2. 배열의 범위를 벗어나지 않을 것
3. 배추 흰 지렁이 수를 어디서 +1 할 것 인지
*/

import java.util.*;

public class Main {
	static int[][] field;
	static int count;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testCount	= scan.nextInt();
		
		for (int t = 0; t < testCount; t++) {
			int fieldM = scan.nextInt();
			int fieldN = scan.nextInt();
			int k	   = scan.nextInt();
			
			field = new int[fieldN][fieldM];
			
			for (int i = 0; i < k; i++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				field[y][x] = 1; 
			}
			
			count = 0;
			for (int i = 0; i < fieldN; i++) {
				for (int j = 0; j < fieldM; j++) {
					if (field[i][j] == 1) {
						countWorm(field, j, i);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	static void countWorm(int[][] array, int x, int y) {
		if (array[y][x] != 1) {
			return;
			
		} else {
			array[y][x] = 0;
			
			if (y-1 >= 0)
				countWorm(field, x, y-1);
			if (x-1 >= 0)
				countWorm(field, x-1, y);
			if (x+1 < array[y].length)
				countWorm(field, x+1, y);
			if (y+1 < array.length)
				countWorm(field, x, y+1);
		}
	}
	
}
