"""
접근 방법

알고리즘: 힙
heapq(최소힙) 함수 이용

heapify: 리스트를 힙 형태로 만들어줌 => O(N)
heappop: 힙에서 가장 작은 원소 pop
heappush: 힙에 원소 삽입

heap에서 가장 작은수, 다음 작은 수를 pop한 뒤 계산하고 다시 힙에 넣는다.
힙의 첫번째 원소가 K보다 큰 경우는 모든 수가 K보다 크다는 의미이므로 종결조건
"""

import heapq

def solution(scovile, K):
    heapq.heapify(scovile)
    cnt = 0

    # scovile의 최소 길이는 2 이상
    while len(scovile) >= 2:
        cnt += 1
        temp = heapq.heappop(scovile) + heapq.heappop(scovile) * 2
        heapq.heappush(scovile, temp)
        if scovile[0] >= K:
            return cnt
        
    if scovile[0] >= K:
        return cnt 
    else:
        return -1
