"""
투포인터
배열의 크기가 100,000이기 때문에 2중포문은 시간초과

WHILE문을 이용해 START와 END포인트 값을 하나씩 늘리거나 줄여가면서 확인한다.
WHILE문의 경우 BREAK 포인트 지정에 신경쓸 것
"""

def solution(gems):
    total_len = len(set(gems))

    dic = {}
    answer = []

    start = 0
    end = 0

    mins = len(gems) + 1

    while end < len(gems):
        if gems[end] in dic:
            dic[gems[end]] += 1
        else:
            dic[gems[end]] = 1
        
        end += 1

        if len(dic) == total_len:
            while start < end:
                if dic[gems[start]] > 1:
                    dic[gems[start]] -= 1
                    start += 1
                elif mins > end - start:
                    mins = end - start
                    answer = [start+1, end]
                    break
                else:
                    break
    return answer
  
  
  
