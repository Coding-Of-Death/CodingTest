from collections import deque

def dfs(v):
    print(v, end=' ')
    visit[v] = 1
    for i in range(1, n+1):
        if visit[i]==0 and graph[v][i]==1:
            dfs(i)

def bfs(v):
    queue = deque()
    queue.append(v)
    visit[v] = 1
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in range(1, n+1):
            if visit[i] == 0 and graph[v][i] == 1:
                queue.append(i)
                visit[i] = 1

n, m, v = map(int, input().split())
graph = [[0]*(n+1) for i in range(n+1)]
for i in range(m):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

visit = [0]*(n+1)
dfs(v)
print()
visit = [0]*(n+1)
bfs(v)
print()
