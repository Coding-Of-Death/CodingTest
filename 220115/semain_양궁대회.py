
# 중복 조합
from itertools import combinations_with_replacement as combi
from collections import Counter

def solution(n, info):
    answer = [0]*11
    max_score = 0
    real_ryan = {}
    for comb in combi(range(11), n):
        ryan = Counter(comb)
        apeach_score = 0
        ryan_score = 0
        
        for i in range(1, 11):
            if info[10-i] < ryan[i]:
                ryan_score += i
            elif info[10-i] > 0:
                apeach_score += i
                
        score = ryan_score - apeach_score
        if score > max_score:
            max_score = score
            real_ryan = ryan
    
    if max_score > 0:
        for r in real_ryan:
            answer[10-r] = real_ryan[r]
        return answer
    else:
        return [-1]


# dfs
global result
global answer
answer = [0] * 11
result = 0

def get_score(ryan, info):
    score = 0
    for i in range(11):
        if info[i] == ryan[i] == 0:
            continue
        # 라이언의 점수를 더하고 어피치의 점수를 빼면 차이
        if info[i] < ryan[i]:
            score += 10 - i
        else:
            score -= 10 - i
    return score

def dfs(idx, n, ryan, info):
    global result
    global answer
    if idx == -1 and n:
        return
    if n == 0:
        score = get_score(ryan, info)
        if result < score:
            answer = ryan[:]
            result = score
        return
    for i in range(n, -1, -1):
        ryan[idx] = i
        dfs(idx-1, n-i, ryan, info)
        ryan[idx] = 0

def solution(n, info):
    dfs(10, n, [0]*11, info)
    return answer if result != 0 else [-1]
  
  
