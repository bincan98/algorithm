"""
N 보다 같거나 작은 수들을 리스트에 모두 넣고

부분집합으로 모든 경우의 수를 체크해보기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = []
for i in range(21):
    temp = int(3 ** i)
    if temp <= N:
        lst.append(temp)

selected = [False] * len(lst)
possible = False


def subset(cur):
    global possible
    if possible:
        return
    if cur == len(lst):
        sum_value = 0
        for i in range(len(lst)):
            if selected[i]:
                sum_value += lst[i]
        if sum_value == N:
            possible = True
        return
    selected[cur] = True
    subset(cur + 1)
    selected[cur] = False
    subset(cur + 1)


subset(0)

print("YES" if N != 0 and possible else "NO")
