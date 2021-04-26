"""
이분탐색

범위 제한이 1,000,000,000이기 때문에 전체 탐색은 불가능 => 이분탐색

이분탐색할 값: 한 명의 심사관에게 얼마만큼의 시간을 줄 건지
이분탐색 기준: 주어진 시간 동안 심사관이 심사를 했을 때 n명 미만/이상으로 심사를 마쳤는지

심사를 마친 사람 수가 n명 이상이면 심사 시간을 줄이고
n명 미만이면 심사 시간을 늘려가면서 최솟값 탐색
"""

def solution(n, times):
    left = 1
    # 한 명이 전부 검사할 최대 시간
    right = max(times) * n
    answer = 0
    while left <= right:
        mid = (left + right) // 2
        # 한 명이 담당하는 시간
        cnt = 0
        for i in range(len(times)):
            # 주어진 시간 동안 몇 명을 심사할 수 있는지
            cnt += mid // times[i]
            # 모든 사람을 심사한다면 시간을 줄여봄
            if cnt >= n: 
                answer = mid
                right = mid - 1
                break
        if cnt < n:
            left = mid + 1
    return answer
  
  
  
