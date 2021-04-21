def dfs(begin, target, words, visited):
    answer = 0
    stacks = [begin]
    while stacks:
        stack = stacks.pop()
        
        if stack == target:
            return answer
        
        for i in range(len(words)):
            if len([j for j in range(0, len(words[i])) if words[i][j] != stack[j]]) == 1:
                if visited[i] != 0:
                    continue
                visited[i] = 1
                stacks.append(words[i])
        answer += 1
    return answer
        
def solution(begin, target, words):
    if target not in words:
        return 0
    
    visited = [0]*len(words)
    answer = dfs(begin, target, words, visited)
    return answer
