"""
접근 방법
완전 탐색

하지만 조건을 봤을 때 개수가 n개 이하로 제한됨
=> 완전 탐색을 했을 시 시간복잡도가 상승하여 좋은 방법이 아님

리스트의 값이 전체 길이에서 해당 리스트의 값을 뺀 값보다 같거나 클 때 h-index에 해당함.
"""

# my solution
def solution(citations):
    max = 0
    while True:
        cit = 0
        for i in range(len(citations)):
            if citations[i] >= max:
                cit += 1
        if cit >= max:
            max += 1
        else:
            return max - 1
          
  
  
  
# other solutions
# 정렬 후 index값을 뒤에서 앞으로 가면서 확인하여 효율이 더 좋음.
def solution(citations):
    citations = sorted(citations)
    l = len(citations)
    for i in range(l):
        if citations[i] >= l-i:
            return l-i
    return 0
  
  
# 대단한 풀이...
# enumerate로 (1, 6) (2, 5) (3, 3) (4, 1) (5, 0)으로 값을 짝짓고 min으로 해당 튜플의 최솟값만 취함 => 1, 2, 3, 1, 0
# 그 중 max값인 3으로 h-index를 구하는 참신한 방법!!!!
def solution(citations):
    citations.sort(reverse=True)
    answer = max(map(min, enumerate(citations, start=1)))
    return answer
  
  
