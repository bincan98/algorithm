import sys

input = sys.stdin.readline

while True:
    lst = list(input().rstrip())
    # print(lst)
    if lst[0] == '0':
        if len(lst) == 1:
            break
        else:
            lst = lst[1:len(lst)+1]
            print(lst)
    reversLst = lst[::-1]
    # print(reversLst)
    if lst == reversLst:
        print('yes')
    else:
        print('no')