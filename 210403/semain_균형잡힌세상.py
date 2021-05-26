import sys

while 1:
    arr = []
    str = sys.stdin.readline().rstrip()
    if str == '.':
        break
    for s in str:
        if s == '(':
            arr.append(0)
        elif s == '[':
            arr.append(1)
        elif s == ')':
            if not arr:
                print("no")
                break
            if arr and arr.pop():
                print("no")
                break
        elif s == ']':
            if not arr:
               print("no")
               break
            if arr and not arr.pop():
                print("no")
                break
    else:
        if arr:
            print("no")
        else:
            print("yes")
