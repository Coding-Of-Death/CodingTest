"""
접근 방법

탐욕법은 그 순간의 최적의 답이 결국은 최선의 답이 되는 것.

1. 여벌 체육복을 가진 학생이 도난당했을 경우의 중복을 제외해준다. => 차집합으로 해결
2. 바로 양옆에 있는 학생에게 빌려준다. => 옆 학생이 체육복이 없으면 리스트에서 제거
3. 리스트에 남아있는 학생은 체육 수업을 들을 수 없으니 전체에서 뺀다.
"""

def solution(n, lost, reserve):
    # 여별 체육복 학생이 도난당했을 때 중복 제외
    r_lost = set(lost) - set(reserve)
    r_reserve = set(reserve) - set(lost)
    
    for i in r_reserve:
        if i-1 in r_lost:
            r_lost.remove(i-1)
        elif i+1 in r_lost:
            r_lost.remove(i+1)
    return n-len(r_lost)
