
def solution(N, number):
    dp = []
    answer = -1
    # 최솟값이 8보다 크면 -1 => 1~8까지 N을 붙여봄
    for i in range(1, 9):
        num = set()
        num.add(int(str(N) * i))
        
        # N이 4개 ==> 1번째 3번째, 2번째 2번째, 3번째 1번째
        for j in range(i-1):
            for x in dp[j]:
                for y in dp[-j-1]:
                    num.add(x+y)
                    num.add(x-y)
                    num.add(x*y)
                    
                    if not y == 0:
                        num.add(x//y)
                        
        if number in num:
            answer = i
            break
        
        dp.append(num)
        
    return answer
    
