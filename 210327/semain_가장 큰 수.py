def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x:x*3, reverse=True)
    return str(int(''.join(numbers)))
  
  
 """
 문제 풀이
 
 힌트: numbers의 원소는 0 이상 1,000 이하
 
 *모든 조합을 구하려고 할 때 시간 복잡도는 (O(numbers)!)
    ==> 1초를 넘어감
    ==> 정렬과 탐색은 nlogn의 시간 복잡도를 기준으로 잡아야 함
 
 예시) numbers = [6, 10, 2]
 
 1. 각 문자열을 반복함
    numbers = ['6(66)', '10(1010)', '2(22)']
 
 2. 문자열을 기준으로 역순으로 정렬
    numbers = ['6(66)', '2(22)', '10(1010)']
    (뒤가 뭐가 나오든 앞 자리가 큰 순으로)
    (혹은 3자리씩 잘라서 큰 순서대로 정렬)
 
 3. 문자열 리스트를 서로 합침
    numbers = ['6210']
    

 고려해야 하는 케이스)
 [0, 0, 0, 0]의 경우 '0000'이 아니라 '0'이 나와야 한다.
 
 
 기억해야 하는 함수 사용법
 sort(key = lamda x : 수식 x, reverse = True)
 
 """
