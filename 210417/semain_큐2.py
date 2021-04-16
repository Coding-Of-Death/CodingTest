"""
주의점

시간제한 1초 (파이썬은 3초)
=> pop(0)은 모든 원소를 왼쪽으로 옮기는 작업이 들어가기 때문에 O(N)
=> deque의 popleft의 시간복잡도는 O(1)

다른 풀이방법
pop하는 작업을 하지 않고 idx를 계산해서 옮겨다니는 방법이 있다.
"""

import sys
from collections import deque

n = sys.stdin.readline()

li = deque()

for i in range(int(n)):
    val = sys.stdin.readline().split()
    if val[0] == "push":
        li.append(int(val[1]))
    elif val[0] == "pop":
        if not li:
            print(-1)
        else:
            print(li.popleft())
    elif val[0] == "size":
        print(len(li))
    elif val[0] == "empty":
        if li:
            print(0)
        else:
            print(1)
    elif val[0] == "front":
        if not li:
            print(-1)
        else:
            print(li[0])
    elif val[0] == "back":
        if not li:
            print(-1)
        else:
            print(li[-1])
