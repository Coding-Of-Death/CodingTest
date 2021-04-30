/*  코드 참고 : https://pangsblog.tistory.com/56  */
/*	
 * 	설명 : https://m.blog.naver.com/ka28/221850826909
 * 
 * 	BufferedReader : Scanner와 유사
 * 	BufferedWriter : System.out.println()과 유사
 * 
 * 	입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달되므로 데이터 처리 효율성을 높임
 * 	둘 모두 속도 측면에서 훨씬 빠르기 때문에 많은 양의 데이터를 처리할 때 유리하다.
 * 	단, BufferedReader의 경우 Enter만 경계로 인식, 받은 데이터가 String으로 고정되기 때문에
 * 	입력받은 데이터를 가공하는 작업이 필요
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer> edge[];
	
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int n = keyboard.nextInt();
		int m = keyboard.nextInt();
		int v = keyboard.nextInt();
		
		// 인덱스는 0부터 시작하다보니 인덱스에 맞추면 node가 헷갈린다.
		// 그래서 0번은 쓰지 않는다 생각하고 크기를 1씩 늘려줌
		edge = new LinkedList[n + 1];
		boolean dfsVisited[] = new boolean[n + 1];
		boolean bfsVisited[] = new boolean[n + 1];
		
		for (int i = 0; i < n + 1; i++) {
			edge[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < m; i++) {
			int vertex1 = keyboard.nextInt();
			int vertex2	= keyboard.nextInt();
			
			// 양방향이라서
			edge[vertex1].add(vertex2);
			edge[vertex2].add(vertex1);
			
			// 정렬함수 외우기
			Collections.sort(edge[vertex1]);
			Collections.sort(edge[vertex2]);
		}
		
		dfs(v, dfsVisited);
		System.out.println();
		bfs(v, bfsVisited);
			
	}
    
    public static void dfs(int v, boolean[] visited) {
		if (visited[v])	return;
		
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int nextV : edge[v]) {
			dfs(nextV, visited);
		}
	}
	
	public static void bfs(int v, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		
		while (!queue.isEmpty()) {
			v = queue.poll();
			
			if(visited[v])		continue;
			
			visited[v] = true;
			System.out.print(v + " ");
			
			for (int nextV : edge[v]) {
				queue.add(nextV);
			}
		}
		
	}

}
