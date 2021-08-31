import sys
input = sys.stdin.readline

num = list(map(int, input().split()))
idx = 0

flag = 0
while True:
	if num[idx] > num[idx+1]:
		num[idx], num[idx+1] = num[idx+1], num[idx]
		flag = 1
		print(*num)
	idx+=1
	
	if idx == len(num)-1:
		idx = 0
		if not flag:
			break
		flag = 0
