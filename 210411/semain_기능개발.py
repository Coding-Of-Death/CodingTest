"""
접근 방법

초기 접근
처음에는 각 배열에 실제로 speeds를 더해서 구하려고 했음
하지만 쓸데없는 삽입이 일어나기 때문에 별로 좋지 않음

=> time 변수를 설정하여 time변수와 speed를 곱하여 비교하는 방법으로 변경

1. 100%가 넘으면 해당 값을 pop하고 cnt 증가시킴
2. 100%가 넘지 않았을 때, cnt값이 0보다 크면 answer에 추가하고 초기화 => 같이 배포되는 기능 cnt. time을 1씩 증가시킴
3. 마지막으로 배포되는 cnt를 추가함. 
"""


def solution(progresses, speeds):
    answer = []
    time = 0
    count = 0
    
    while progresses:
        if (progresses[0] + time*speeds[0]) >= 100: 
            progresses.pop(0)
            speeds.pop(0)
            count += 1
            
        else:
            if count > 0:
                answer.append(count)
                count = 0
            time += 1
    answer.append(count)
    return answer
