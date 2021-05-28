# 투포인터 기본
import sys
n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
num = 0
cnt = 0
j = 0
for i in range(n):
    while num < m and j < n:
        num += a[j]
        j += 1
    if num == m:
        cnt += 1
    num -= a[i]
print(cnt)
