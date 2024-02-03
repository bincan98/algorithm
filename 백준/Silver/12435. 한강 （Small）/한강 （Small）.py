"""
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()


def weak(a):
    lst = []
    for i in range(2, int(a ** 0.5) + 1):
        if a % i == 0:
            lst.append(i)
    for el in lst[::-1]:
        if el * el != a:
            lst.append(a // el)
    list_dict[len(lst)].append(a)
    min_value = 0
    if len(lst) != 0:
        min_value = min(lst)
    return [len(lst), min_value]


arr = [[] for _ in range(1_000_000 + 1)]
list_dict = defaultdict(list)

for i in range(2, 1_000_000 + 1):
    arr[i] = weak(i)

for t in range(int(input())):
    N, M = map(int, input().split())

    answer = 0
    if arr[N][0] == 0:
        print(f'Case #{t + 1}: {answer}')
        continue

    for a in list_dict[arr[N][0]]:
        if a >= N:
            break
        if arr[a][1] >= M:
            answer += 1

    print(f'Case #{t + 1}: {answer}')