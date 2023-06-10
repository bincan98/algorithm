"""
1 3
2 3 + 2
3 3 + 2 + 4
4 ... + 4

어떤 좌표가 0,0 에 연결되는지 알아보는 방법
x, y가 같은 수로 나누어지면 보이지 않는다
이게핵심) 즉 같은 수로 나누어지지 않으면 됨
즉 x, y의 최대공약수가 1이면 보이는 수이다
"""


def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


# 갯수 저장할 배열
dp = [0] * 1001

# 모든 좌표 다 구하기
for i in range(1, 1001):
    for j in range(1, 1001):
        if gcd(max(i, j), min(i, j)) == 1:  # a에 둘 중 큰값을 넣어주어야 함
            dp[max(i, j)] += 1  # 둘 중 큰 좌표가 N이 된다

# (0,1), (1,0)도 보이므로 더해주기 (좌표 구할떄 0부터 하면 % 0 불가 오류 뜸)
dp[1] += 2

# 여태 구한거 합치기
for i in range(1, 1001):
    dp[i] += dp[i - 1]

N = int(input())
for i in range(N):
    # 입력 즉시 출력
    print(dp[int(input())])