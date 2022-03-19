package programmers;

public class PG_피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dun = {{80,20},{50,40},{30,10}};

		System.out.println(solution(k, dun));
	}

	static boolean[] visited;
	static int max;
	public static int solution(int k, int[][] dungeons) {
		int answer = -1;
		visited = new boolean[dungeons.length];
		max = Integer.MIN_VALUE;

		dfs(k, dungeons, 0);

		return max;
	}

	static void dfs(int hp, int[][] dungeon, int cnt) {
		for (int i = 0; i < dungeon.length; i++) {
			if (!visited[i] && hp >= dungeon[i][0]) {
				visited[i] = true;
				dfs(hp - dungeon[i][1], dungeon, cnt + 1);
				visited[i] = false;
			}
		}
		max = Math.max(max, cnt);
	}
}
