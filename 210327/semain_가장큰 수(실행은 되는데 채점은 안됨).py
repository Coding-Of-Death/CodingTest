from itertools import permutations

#permutations => 순열(nPr)
def solution(numbers):
    numbers = list(map(str, numbers))
    a = list(map(''.join, permutations(numbers)))
    answer = max(a)
             
    return answer

"""
채점 안 되는 이유
itertools는 리스트의 크기가 클수록 연산 속도가 매우 느려지기 때문에 시간 초과.
"""
