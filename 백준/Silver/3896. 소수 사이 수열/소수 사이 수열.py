"""
정수론

k 가 소수인지 구하고 소수라면 그만
아니라면 k-1,k+1이 소수인지 구하기
쭉쭉 -1 +1 하면서 범위 구하기

에라토스테네스 하고 소수 판별해보기?

1 ~ 1_299_709

시간복잡도는 NlogN 이니까 가능
"""
import sys

input = lambda: sys.stdin.readline().strip()

is_prime = [True] * (1_299_709 + 1)

for i in range(2, int((1_299_709 + 1) ** 0.5)):
    for j in range(i, 1_299_709):
        if i * j > 1_299_709:
            break
        is_prime[i * j] = False

T = int(input())

for i in range(T):
    k = int(input())
    if is_prime[k]:
        print(0)
    else:
        result = 1
        current = k + 1
        while True:
            if is_prime[current]:
                break
            result += 1
            current += 1
        current = k - 1
        while True:
            if is_prime[current]:
                break
            result += 1
            current -= 1
        print(result + 1)