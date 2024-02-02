"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

for _ in range(int(input())):
    lst = []
    for _ in range(int(input())):
        lst.append(list(map(int, input().split())))

    lst = sorted(lst)

    cong = [lst[0]]
    for i in range(1, len(lst)):
        if cong[-1][0] > lst[i][0] or cong[-1][1] > lst[i][1]:
            cong.append(lst[i])

    print(len(cong))