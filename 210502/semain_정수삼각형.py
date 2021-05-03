"""
        7
      3   8
    8   1   0
  2   7   4   4
4   5   2   6   5

위 -> 아래
맨 왼쪽과 맨 오른쪽 수는 바로 직전의 값만 더하면 됨
가운데 있는 수는 전 줄의 왼쪽과 오른쪽 값 중 큰 값을 더함
"""

def solution(triangle):
    for i in range(1, len(triangle)):
        for j in range(i+1):
            if j == 0:
                triangle[i][j] += triangle[i-1][j]
            elif j == i:
                triangle[i][j] += triangle[i-1][j-1]
            else:
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
                
    return max(triangle[-1])
