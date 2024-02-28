"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

def hanoi(cnt, source, target, left):
    if cnt == 0:
        return 0
    result = 0
    result += hanoi(cnt - 1, source, left, target)
    lst.append(str(source) + " " + str(target))
    result += hanoi(cnt - 1, left, target, source)
    return result + 1

lst = []
answer = hanoi(N, 1, 3, 2)
print(answer)
for a in lst:
    print(a)