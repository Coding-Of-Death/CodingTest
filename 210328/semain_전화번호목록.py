"""

접근 방법

1. 한 번호가 다른 번호의 접두어이다 ==> 앞의 일정 부분 숫자가 같다.
2. 일정부분이 같기 때문에 sort를 하게 되면 앞 부분이 비슷한 숫자가 모인다.
3. 다음 수와 같은 부분만 비교하면 된다.

"""

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        if phone_book[i] == phone_book[i+1][:len(phone_book[i])]:
            return False
    return True
  
  
