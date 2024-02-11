import sys

input = lambda: sys.stdin.readline().strip()

lst = list(map(int, input().split()))

cnt = 1
while lst[0] != 0:
    print(f'Case {cnt}: Sorting... done!')
    cnt += 1
    lst = list(map(int, input().split()))