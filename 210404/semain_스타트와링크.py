# 완전탐색(브루트포스)
import sys
from itertools import combinations
n = int(sys.stdin.readline())
people = [i for i in range(n)]
start = []
link = []
min_ability = 100
ability = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
team = list(combinations(people, n//2))
for i in range(len(team)//2):
    start.append(list(combinations(team[i], 2)))
    link.append(list(combinations(team[len(team)-i-1], 2)))

for teams, teaml in zip(start, link):
    start_ability = 0
    link_ablitly = 0 
    for x, y in zip(teams, teaml):
        start_ability += ability[x[0]][x[1]]
        start_ability += ability[x[1]][x[0]]
        link_ablitly += ability[y[0]][y[1]]
        link_ablitly += ability[y[1]][y[0]]
    total_ability = abs(start_ability - link_ablitly)
    min_ability = min(total_ability, min_ability)
print(min_ability)



#dfs (pypy3로만 통과)
import sys

def dfs(idx, cnt):
    global min_ability

    if cnt == n//2:
        start, link = 0, 0
        for i in range(n):
            for j in range(n):
                if people[i] and people[j]:
                    start += ability[i][j]
                elif not people[i] and not people[j]:
                    link += ability[i][j]
        min_ability = min(min_ability, abs(start-link))

    for i in range(idx, n):
        if not people[i]:
            people[i] = 1
            dfs(i, cnt + 1)
            people[i] = 0



n = int(sys.stdin.readline())
people = [0 for i in range(n)]
ability = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
min_ability = 100
dfs(0, 0)
print(min_ability)
