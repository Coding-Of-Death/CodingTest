"""
접근방법

문제 그대로의 큐를 구현해주면 된다.

1. 첫 대기순서의 우선순위가 가장 큰지 확인
2. 우선순위가 클 때 -> location이 일치하면 반환 or location이 불일치하면 큐 마지막으로 보내고 location 조정
2. 우선순위가 작을 떄 -> 큐 마지막으로 보내고 location 조정
"""

def solution(priorities, location):
    cnt = 0
    while priorities:
        if priorities[0] == max(priorities):
            priorities.pop(0)
            cnt += 1
            if location == 0:
                return cnt
            else:
                location -=1
        else:
            priorities.append(priorities.pop(0))
            if location == 0:
                location = len(priorities)-1
            else:
                location -= 1
