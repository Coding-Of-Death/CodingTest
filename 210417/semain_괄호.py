"""
접근 방법

1. '('는 무조건 스택에 저장한다.
2. ')'를 만났을 때 저장한 '('를 pop한다.
3. 저장한 '('가 없거나 스택에 '('가 남아있을 경후 짝이 맞지 않는 것으로 간주한다.

아쉬운 점
처음에 '('의 개수와 ')'의 개수를 세어 불일치하는 경우를 먼저 제외하고 갔다면
조금 더 효율적인 코드가 되지 않았을까 함
"""

n = int(input())
for i in range(n):
    ps = list(map(str, input()))
    temp = []
    flag = "YES"
    for j in ps:
        if j == '(':
            temp.append(j)
        else:
          if temp:
            temp.pop()
          else:
            flag = "NO"
    if temp:
       flag = "NO"
    print(flag)
