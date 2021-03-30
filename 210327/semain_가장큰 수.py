from itertools import permutations

#permutations => 순열(nPr)
def solution(numbers):
    numbers = list(map(str, numbers))
    a = list(map(''.join, permutations(numbers)))
    answer = max(a)
             
    return answer
