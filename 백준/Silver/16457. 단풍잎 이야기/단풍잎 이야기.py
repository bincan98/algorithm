"""
조합으로 가능한 경우의 수를 모두 체크하자

시간복잡도가 간당간당할듯
"""
import sys

input = lambda: sys.stdin.readline().strip()

n, m, k = map(int, input().split())

lst = []
for i in range(m):
    lst.append(list(map(int, input().split())))

selected = [0] * n
answer = 0


def recur(cur, nxt):
    if cur == n:
        global answer
        result = 0
        for i in range(m):
            possible = True
            for j in range(k):
                if lst[i][j] in selected:
                    continue
                else:
                    possible = False
                    break
            if possible:
                result += 1
        answer = max(answer, result)
        return
    for i in range(nxt, 2*n+1):
        selected[cur] = i
        recur(cur + 1, i + 1)


recur(0, 1)
print(answer)