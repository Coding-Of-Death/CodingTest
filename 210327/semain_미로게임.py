from collections import deque

n, m = map(int, input().split())
maze = [list(map(int, input())) for _ in range(n)]
visited = [[0]*(m) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

queue = deque()
queue.append((0,0))
visited[0][0] = 1
while queue:
    a, b = queue.popleft()
    
    if a == n-1 and b == m-1:
        print(visited[a][b])
        break
    
    for i in range(4):
        nx = a + dx[i]
        ny = b + dy[i]
        
        if 0 <= nx < n and 0 <= ny < m:
            if maze[nx][ny] == 1 and visited[nx][ny] == 0:
                visited[nx][ny] = visited[a][b] + 1
                queue.append((nx, ny))
