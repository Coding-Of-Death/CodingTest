"""
접근 방법

1. key값대로 dic에 넣는다.
2. val값의 개수만큼 서로 곱하여 조합을 구한다.
3. +1 해주는 이유는 안 입는 경우가 있기 때문.
4. answer - 1 해줘서 전부 안 입는 경우를 제거해야 한다.
"""

def solution(clothes):
    answer = 1
    dic = {}
    
    for val, key in clothes:
        if key in dic.keys():
            dic[key].append(val)
        else:
            dic[key] = [val]
            
    for val in dic.values():
        answer *= (len(val)+1)
    return answer - 1
