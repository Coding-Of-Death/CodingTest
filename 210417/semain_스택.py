"""
스택

input()은 시간초과날 가능성이 있음.
sys.stdin.readline()을 이용 => str형태
"""

# 함수 이용
import sys

def push(x):
    li.append(x)

def pop():
  if not li:
    print(-1)
  else:
    print(li.pop())
    
def size():
    print(len(li))

def empty():
  if not li:
    print(1)
  else:
    print(0)

def top():
  if not li:
    print(-1)
  else:
    print(li[len(li) - 1])


n = sys.stdin.readline()
li = []

for i in range(int(n)):
    val = sys.stdin.readline().split()
    if val[0] == "push":
        push(int(val[1]))
    elif val[0] == "top":
        top()
    elif val[0] == "pop":
        pop()
    elif val[0] == "size":
        size()
    elif val[0] == "empty":
        empty()
        
        
# 함수 비이용
import sys
n = sys.stdin.readline()
li = []
for i in range(int(n)):
    a = sys.stdin.readline().split()
    if a[0]=="push":
        li.append(int(a[1]))
    elif a[0]=="pop":
        if not li:
            print(-1)
        else:
            print(li.pop())
    elif a[0]=="size":
        print(len(li))
    elif a[0]=="empty":
        if not li:
            print(1)
        else:
            print(0)
    elif a[0]=="top":
        if not li:
            print(-1)
        else:
            print(li[len(li)-1])
