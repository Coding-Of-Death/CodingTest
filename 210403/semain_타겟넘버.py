"""
접근 방법

1. +1 -1을 루트노드로 갖는다.
2. 루트 노드에 +1 -1을 하면서 서브 노드에 추가한다.
3. 모든 경우의 수가 생긴 루트 노드에서 타겟 넘버와 일치하는 숫자를 반환한다.
"""


def solution(numbers, target):
    sup = [0]
    for i in numbers:
        sub = []
        for j in sup:
            sub.append(j+i)
            sub.append(j-i)
        sup = sub
    return sup.count(target)
