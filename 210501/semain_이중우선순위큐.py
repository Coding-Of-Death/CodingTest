# 힙을 쓰지 않은 풀이
def solution(operations):
    q = []
    for op in operations:
        a, b = op.split()
        if a == 'I':
            q.append(int(b))
        elif a == 'D':
            if q:
                if b == '1':
                    q.pop()
                else:
                    q.pop(0)
            else:
                pass
        q.sort()
    if not q:
        return [0, 0]
    else:
        return [q[-1], q[0]]
      
      

# 힙을 쓴 풀이
"""
 heap 내장함수로 max값과 min값을 구해주는 함수가 있음.
 heapq.nlargest(n, iterable, key=None) 
 smallest 동일
 => iterable에 의해 정의된 데이터 집합에서 n 개의 가장 큰 요소로 구성된 리스트를 반환
 
 내장함수 이외에 max heap과 min heap을 직접 만들어서 같이 삽입, 삭제하면서 찾는 방법도 있음.
"""
import heapq

def solution(operations):
    heap = []
    for op in operations:
        a, b = op.split()
        if a == 'I':
            heapq.heappush(heap, int(b))
        else:
            if heap:
                if b == "1":
                    heap.pop(heap.index(heapq.nlargest(1, heap)[0]))
                else:
                    heapq.heappop(heap)
    if not heap:
        return [0, 0]
    else:
        return [heapq.nlargest(1, heap)[0], heapq.nsmallest(1, heap)[0]]
      
      
      
      
      
      
