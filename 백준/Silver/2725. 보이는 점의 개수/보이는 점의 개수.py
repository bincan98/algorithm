"""
1 3
2 3 + 2
3 3 + 2 + 4
4 ... + 4

어떤 좌표가 0,0 에 연결되는지 알아보는 방법
x, y가 같은 수로 나누어지면 보이지 않는다
이게핵심) 즉 같은 수로 나누어지지 않으면 됨
즉 최대공약수가 1이면 보이는 수이다
"""


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


dp = [0] * 1001

for i in range(1, 1001):
    for j in range(1, 1001):
        if gcd(max(i, j), min(i, j)) == 1:
            dp[max(i, j)] += 1

dp[1] += 2

for i in range(1, 1001):
    dp[i] += dp[i-1]

N = int(input())
for i in range(N):
    print(dp[int(input())])