"""
접근 방법

이중 for문으로 가격 비교한 후 카운트한다.

**이중 for문은 시간복잡도가 O(N^2)이기 때문에 데이터가 커질 경우에 통과 못할 확률이 큼**
"""

def solution(prices):
    answer = [0]*len(prices)
    for i in range(len(prices)-1):
        for j in range(i, len(prices)-1):
            if prices[i] > prices[j]:
                break
            else:
                answer[i] +=1
    
    return answer
