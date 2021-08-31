from collections import defaultdict

def solution(s):
    dic = defaultdict(int)
    answer = []
    s = s.replace('{', '')
    s = s.replace('}', '')
    li = s.split(',')
    for x in li:
        dic[x] += 1
    dic = sorted(dic.items(), key=lambda x:x[1], reverse=True)
    answer = [int(a) for a, _ in dic]
    return answer
