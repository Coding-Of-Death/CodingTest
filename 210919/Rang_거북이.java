import java.util.*;


public class Main {
	final static int PY = 0;
	final static int PX = 1;
	final static int NY = 2;
	final static int NX = 3;
	
	static int minX, minY, maxX, maxY;
	static int[] turtle = new int[3];	// 방향, y좌표, x좌표
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 0; tc < T; tc++) {
			char[] command = sc.nextLine().toCharArray();
			minX = 0;	minY = 0;
			maxX = 0;	maxY = 0;
			turtle[0] = PY;	turtle[1] = 0;	turtle[2] = 0;
			
			for (int i = 0; i < command.length; i++) {
				switch(command[i]) {
					case 'F':
						go('F');
						break;
					case 'B':
						go('B');
						break;
					case 'R':
						turtle[0] = (turtle[0] + 1)%4;
						break;
					case 'L':
						if (turtle[0] == 0)
							turtle[0] = 3;
						else
							turtle[0]--;
						break;
				}
				
				minX = Math.min(minX, turtle[2]);
				minY = Math.min(minY, turtle[1]);
				maxX = Math.max(maxX, turtle[2]);
				maxY = Math.max(maxY, turtle[1]);
			}
			
			System.out.println(Math.abs(maxX - minX)*Math.abs(maxY-minY));
		}
	}
	
	static void go(char c) {
		int step = 0;
		
		if (c == 'F')	step = 1;
		else			step = -1;
		
		if (turtle[0] == PY)
			turtle[1] += step;
		else if (turtle[0] == PX)
			turtle[2] += step;
		else if (turtle[0] == NY)
			turtle[1] -= step;
		else
			turtle[2] -= step;
	}
}
