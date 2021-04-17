/*
 * 참조 : https://bellog.tistory.com/109
 * 참조 : https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-16236-%EC%95%84%EA%B8%B0-%EC%83%81%EC%96%B4
 * 
 * 최단거리 구하기 + 모든 간선의 가중치 1 ==> BFS
 * */

package BaekJun;

import java.util.*;


class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class Main {
	final static int	BABY_SHARK = 9;
	final static int	BLANK = 0;
	
	final static int[]	DX = {0, -1, 1, 0};	// 순서 중요
	final static int[]	DY = {-1, 0, 0, 1};	// 순서 중요
	
	static int		minDist;
	static Point	minPoint;
	
	static Point	babyShark;
	static int[][]	map;
	static int[][]	distance;
	static int		n;
	static int		babySharkSize = 2;
	
	static LinkedList<Integer> timeList = new LinkedList<>();
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int eatingCount = 0;
		int time = 0;
		
		n = scan.nextInt();
		map	= new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scan.nextInt();
				
				if (map[i][j] == BABY_SHARK) {
					babyShark = new Point(j,i);
				}
			}
		}
		
		map[babyShark.y][babyShark.x] = 0;
		
		while(true) {
			distance = new int[n][n];
			minDist = Integer.MAX_VALUE;
			minPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
			
			startHunt(babyShark.x, babyShark.y);
			
			if (minPoint.x != Integer.MAX_VALUE && minPoint.y != Integer.MAX_VALUE) {
				eatingCount++;
				map[minPoint.y][minPoint.x] = 0;
				time += distance[minPoint.y][minPoint.x];
				
				if (eatingCount == babySharkSize) {
					babySharkSize++;
					eatingCount = 0;
				}
				
				babyShark = new Point(minPoint.x, minPoint.y);
				
			} else {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	static void startHunt(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int i = 0; i < DX.length; i++) {
				int newX = p.x + DX[i];
				int newY = p.y + DY[i];
				
				if (isInArea(newX, newY) && isAbleToMove(newX, newY) && distance[newY][newX] == 0) {
					distance[newY][newX] = distance[p.y][p.x] + 1;
					
					if (isEatable(newX, newY)) {
						if (minDist > distance[newY][newX]) {
                            minDist = distance[newY][newX];
                            minPoint = new Point(newX, newY);
                            
                        } else if (minDist == distance[newY][newX]) {
                            if (minPoint.y == newY) {
                                if (minPoint.x > newX) {
                                	minPoint = new Point(newX, newY);
                                }
                            } else if (minPoint.y > newY) {
                                minPoint = new Point(newX, newY);
                            }
                        }
                    }
					
					queue.add(new Point(newX, newY));
				}
			}
		}
	}
	
	static boolean isInArea(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
	
	static boolean isAbleToMove(int x, int y) {
		return map[y][x] <= babySharkSize;
	}
	
	static boolean isEatable(int x, int y) {
		return map[y][x] != BLANK && map[y][x] < babySharkSize;
	}
}
