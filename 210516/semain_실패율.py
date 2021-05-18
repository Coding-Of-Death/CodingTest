# 단순하게 푼 방법
def solution(N, stages):
    dic = {}
    for i in range(1, N+1):
        cnt = 0
        cnt2 = 0
        for j in stages:
            if j>=i:
                cnt += 1
            if i==j:
                cnt2 += 1
        if cnt == 0:
            dic[i] = 0
        else:
            dic[i] = cnt2 / cnt
    
    dic = sorted(dic, key=lambda x: dic[x], reverse=True)
    
    return dic
    
    
# 더 효율적인 방법    
def solution(N, stages):
    dic = {}
    num = len(stages)
    
    for i in range(1, N+1):
        if num != 0:
            cnt = stages.count(i)
            dic[i] = cnt / num
            num -= cnt
        else:
            dic[i] = 0
            
    return sorted(dic, key=lambda x: dic[x], reverse=True)
  
