"""
관찰
모든 버튼은 누르다보면 색깔이 바뀐다
그럼 몇번만에?

6 4
1 2 3 3 2 1
에서 3번 버튼을 3번눌러야 2와 같은 색이 된다 (3+x)%4 = 2 .. x = 3

그럼 N번 순회하면서 색깔이 바뀌는 지점에 몇번눌러야하는지 체크가능

누적으로 몇번 바꿔야 끝까지 가는지 더해주기 (누적합?)
끝까지 합치는 경우의 수 = max(왼쪽 끝까지 합는 경우의 수, 오른쪽 끝까지 합치는 경우의 수)
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, M = map(int, input().split())
lst = list(map(int, input().split()))

delta = [[0, 0] for _ in range(N)]
cnt = [[0, 0] for _ in range(N)]

for i in range(N-1):
    delta[i][1] = (lst[i+1] - lst[i] + M) % M
    delta[i+1][0] = (lst[i] - lst[i+1] + M) % M

for i in range(1, N):
    cnt[i][0] = cnt[i-1][0] + delta[i][0]

for i in range(N-1)[::-1]:
    cnt[i][1] = cnt[i+1][1] + delta[i][1]
answer = max(cnt[0][0], cnt[0][1])
index = 1
i = 0
for a, b in cnt:
    if max(a, b) < answer:
        answer = max(a, b)
        index = i + 1
    i += 1

print(index)
print(answer)