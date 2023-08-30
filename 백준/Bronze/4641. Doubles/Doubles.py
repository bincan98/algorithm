import sys

input = lambda: sys.stdin.readline().strip()

lst = list(map(int, input().split()))

while lst[0] != -1:
    answer = 0
    for ele in lst:
        if ele * 2 in lst:
            answer += 1
    print(answer - 1)
    lst = list(map(int, input().split()))