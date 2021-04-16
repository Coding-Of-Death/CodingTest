"""
주의사항

큐2와 마찬가지로 시간제한이 있기 때문에 리스트를 사용해서 큐를 구현하면 시간초과된다.
큐를 구현할 땐 O(1)인 deque를 이용하자.
"""

from collections import deque

li = deque()
for x in range(1, int(input())+1):
    li.append(x)

while len(li)>1:
    li.popleft()
    li.append(li.popleft())
print(li[0])
