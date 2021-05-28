"""
python3로는 백트래킹 시간 초과로 통과 불가능.
pypy3만 가능.
"""

def check(row):
    for i in range(row):
        if chess[i]==chess[row] or abs(chess[row]-chess[i])==row-i:
            return False
    return True

def nqueen(row):
    global cnt
  
    if row == n:
        cnt+=1
        return
      
    for i in range(n):
        chess[row] = i
        if check(row):
            nqueen(row+1)

n = int(input())
chess = [0 for _ in range(16)]
cnt = 0
nqueen(0)
print(cnt)
