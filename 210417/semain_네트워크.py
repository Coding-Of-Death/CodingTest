# bfs/dfs 둘 다 가능
# deque로 해야 시간이 조금이나마 단축됨

from collections import deque

# bfs (큐, no 재귀)
def solution(n, computers):
    num = 0
    bfs = deque()
    visited = [0]*n

    while 0 in visited:
        a = visited.index(0)
        bfs.append(a)
        visited[0] = 1

        while bfs:
            no = bfs.popleft()

            for i in range(n):
                if visited[i] ==0:
                    if computers[no][i] == 1:
                        bfs.append(i)
                        visited[i] = 1
        num += 1

    return num
  
  
  
  # bfs (재귀)
  def solution(n, computers):
    visited = [False]*n
    cnt = 0
    for i in range(n):
        if visited[i] == False:
            bfs(n, computers, i, visited)
            cnt +=1
    return cnt

def bfs(n, computers, i, visited):
    q = deque()
    q.append(i)
    
    while q:
        num = q.popleft()
        for k in range(n):
            if visited[k]==False and computers[num][k]==1:
                q.append(k)
                visited[k] = True
                
                
                
# dfs (재귀)
def solution(n, computers):
    answer = 0
    visited = [False]*n
    for i in range(n):
        if visited[i] == False:
            dfs(n, computers, i, visited)
            answer += 1
    return answer

def dfs(n, computers, i, visited):
    for k in range(n):
        if visited[k] == False and computers[i][k] == 1:
            visited[k] = True
            dfs(n, computers, k, visited)
                
              
              
              
