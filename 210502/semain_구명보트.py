# 가장 몸무게 적은 사람 + 많은 사람부터 탐색
# limit보다 적으면 왼쪽 커서 증가, limit보다 크면 오른쪽 커서 감소

def solution(people, limit):
    people.sort()
    cnt = 0
    i = 0 
    j = len(people)-1
    
    while i <= j:
        cnt += 1
        if people[i] + people[j] <= limit:
           i+=1
        j-=1
        
    return cnt
