"""
n이 최대 20억

nCm 오차없이 구하기를 활용해서 구하고 끝자리 0의 개수를 구해보자

-- 최대 10억번 연산하므로 시간초과

nCm = n!/(n-m)!m!

각각 팩토리얼들의 2와 5의 소인수 개수를 구하고 n!의 개수에서 (n-m)! 와 m! 의 개수를 빼자
"""


n, m = map(int, input().split())


if m == 0 or n == m:
    print(0)
else:
    cnt2 = 0
    cnt5 = 0
    # n!의 소인수 2와 5의 개수 구하기
    for i in range(1, n+1):
        if int(2 ** i) > n:
            break
        cnt2 += n // int(2 ** i)
        cnt5 += n // int(5 ** i)
    # m!의 소인수 2와 5의 개수 구해서 원래 개수에서 빼주기
    for i in range(1, m+1):
        if int(2 ** i) > m:
            break
        cnt2 -= m // int(2 ** i)
        cnt5 -= m // int(5 ** i)
    # (n-m)!의 소인수 2와 5의 개수 구해서 원래 개수에서 빼주기
    for i in range(1, (n-m) + 1):
        if int(2 ** i) > (n-m):
            break
        cnt2 -= (n-m) // int(2 ** i)
        cnt5 -= (n-m) // int(5 ** i)
    print(min(cnt2, cnt5))