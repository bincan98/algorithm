"""
LCM = x * y / gcd(x, y)

x * y = GCD * LCM

GCD * LCM 의 약수를 구하면 모든 x와 y의 순서쌍을 알 수 있다

하지만 이렇게 구한 x * y가 항상 올바르게 GCD와 LCM을 가지는건 아니다 (한 명제가 참이어도 역은 알 수 없듯)

따라서 이 순서쌍이 GCD와 LCM을 가지는지 체크해야한다

자연수 쌍이 여러 개 있는 경우에는 두 자연수의 합이 최소가 되는 두 수가 필요하다

약수 구하기에서 for 문이 1부터 루트 N 까지 진행되므로

조건을 만족하는 마지막 두 수가 두 자연수의 합이 최소가 되는 두 수일 것이다
"""


A, B = map(int, input().split())
N = A * B


# 최대공약수 구하기
def gcd(a, b):
    while a % b:
        a, b = b, a % b
    return b


# 약수 구하기
for i in range(1, int(N ** 0.5)+1):
    # 약수라면
    if N % i == 0:
        # 약수 순서쌍으로 최대 공약수 구하기
        GCD = gcd(N // i, i)
        # 최대 공약수와 최소 공배수가 일치하면
        if GCD == A and N // GCD == B:
            x, y = i, N // i


print(f'{x} {y}')