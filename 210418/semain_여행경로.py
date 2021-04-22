def solution(tickets):
    tickets.sort(reverse=True)
    answer = []
    dic = {}
    
    for s, e in tickets:
        if s not in dic:
            dic[s] = [e]
        else:
            dic[s].append(e)

    start = ["ICN"]
    
    while start:
        top = start[-1]
        if top not in dic or len(dic[top]) == 0:
            answer.append(start.pop())
        else:
            start.append(dic[top].pop())
    answer.reverse()
    return answer
