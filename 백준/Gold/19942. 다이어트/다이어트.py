"""
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

ref = list(map(int, input().split()))

ls = []
ls.append([])
for i in range(N):
    ls.append(list(map(int, input().split())))

min_price = 987654321
answer = []


def recur(cur, dan, ji, tan, vi, price, selected):
    if cur == N + 1:
        if dan >= ref[0] and ji >= ref[1] and tan >= ref[2] and vi >= ref[3]:
            global min_price
            if min_price > price:
                min_price = price
                answer.clear()
                answer.append(selected)
            if min_price == price:
                answer.append(selected)
        return
    recur(cur + 1, dan + ls[cur][0], ji + ls[cur][1], tan + ls[cur][2], vi + ls[cur][3], price + ls[cur][4], selected + [cur])
    recur(cur + 1, dan, ji, tan, vi, price, selected)

recur(1, 0, 0, 0, 0, 0, [])
if min_price == 987654321:
    print(-1)
else:
    answer = sorted(answer)
    print(min_price)
    print(*answer[0])