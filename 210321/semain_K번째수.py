def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        a = commands[i][0]
        b = commands[i][1]
        c = commands[i][2]

        s = array[a-1:b]
        s.sort()
        answer.append(s[c - 1])

    return answer
