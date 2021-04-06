"""
접근방법

1. 문자를 조합
=> 조합할 때 같은 경우도 있으므로 set을 사용해서 방지
=> permutations함수는 자릿수를 지정하여 조합이 가능함 (그대로 permutations을 사용할 경우 전체의 조합만 나옴)

2. 조합한 문자를 숫자로 변환

3. 소수 확인
=>에라토스테네스의 체 이용. 소수 식별을 위해 루트 n(파이썬은 n**0.5로 표시)까지만 검사하면 됨
"""


def isPrime(num):
    if num < 2:
        return 0
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return 0
    return 1

def solution(numbers):
    cnt = 0
    nums = set()
    for i in range(1, len(numbers) + 1):
        n = set(map(int, (map(''.join, itertools.permutations(numbers, i)))))
        nums |= n
    
    for i in nums:
        if isPrime(i):
            cnt += 1
    return cnt
    
