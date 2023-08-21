"""
순열


"""
import sys

input = lambda: sys.stdin.readline().strip()

x = []
y = []
for i in range(4):
    a, b = map(int, input().split())
    x.append(a)
    y.append(b)

visited = [False] * 4
selected = [0] * 3
answer = 987654321


def recur(cur):
    if cur == 3:
        # print(*selected)
        global answer
        lst = [0] + selected
        # print(*lst)
        result = 0
        for i in range(3):
            result += ((x[lst[i]] - x[lst[i+1]]) ** 2 + (y[lst[i]] - y[lst[i+1]]) ** 2) ** 0.5
        answer = min(answer, int(result))
        return
    for i in range(1, 4):
        if visited[i]:
            continue
        visited[i] = True
        selected[cur] = i
        recur(cur + 1)
        visited[i] = False


recur(0)
print(answer)