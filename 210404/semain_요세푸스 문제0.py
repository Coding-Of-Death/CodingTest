n, k = map(int, input().split())
people = [i for i in range(1, n+1)]
q = []
idx = k-1
while people:
    q.append(people.pop(idx))
    if not people:
        break
    idx = (idx + k-1) % len(people)
print('<'+', '.join(map(str, q)) + '>')
