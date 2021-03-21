def solution(answers):
    answer = []
    cnt1 = 0
    cnt2 = 0
    cnt3 = 0
    
    a = [1,2,3,4,5]
    b = [2,1,2,3,2,4,2,5]
    c = [3,3,1,1,2,2,4,4,5,5]
    
    
    for i in range(len(answers)):
        if answers[i]==a[i%5]:
            cnt1 += 1
        if answers[i]==b[i%8]:
            cnt2 += 1
        if answers[i]==c[i%10]:
            cnt3 += 1
    
    max_num = max(cnt1, cnt2, cnt3)
    if max_num == cnt1:
        answer.append(1)
    if max_num == cnt2:
        answer.append(2)
    if max_num == cnt3:
        answer.append(3)
        
    answer.sort()
    
    return answer
