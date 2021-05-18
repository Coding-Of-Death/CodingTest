# 비트연산 사용하지 않은 풀이
"""
def solution(n, arr1, arr2):
    answer = []
    map1 = []
    map2 = []
    for ar in arr1:
        bi = bin(ar)[2:]
        if len(bi) != n:
            bi = bi.zfill(n)
        map1.append(bi)
        
    for ar2 in arr2:
        bi = bin(ar2)[2:]
        if len(bi) != n:
            bi = bi.zfill(n)
        map2.append(bi)
    
    for m1, m2 in zip(map1, map2):
        st = ""
        for i in range(n):
            if m1[i] == m2[i] and m1[i] == '0':
                st += " "
            else:
                st += "#"
        answer.append(st)
        
    return answer
"""


# 비트연산 사용
def solution(n, arr1, arr2):
    answer = []
    
    for i, j in zip(arr1, arr2):
        a12 = bin(i|j)[2:]
        a12 = a12.rjust(n, '0')
        a12 = a12.replace('1', '#')
        a12 = a12.replace('0', ' ')
        answer.append(a12)
    return answer
  
  """
  bin(): 10진수를 2진수로 바꿔줌 0bxxxx형태
  zfill(n): n개의 자리수 중 채워지지 않은 문자열 자리수를 0으로 채워줌
  rjust(n, ''): 오른쪽 정렬 후 두 번째 인자값으로 나머지를 채워줌
  """
  
