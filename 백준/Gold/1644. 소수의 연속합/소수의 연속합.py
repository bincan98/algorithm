"""
먼저 N 까지 boolean 배열을 만들고 에라토스테네스의 체로 소수 체크하기

소수들만 따로 모아서 배열 만들기 prime[]

start, end 를 0으로 설정하고

result 는  prime[0]으로 설정하기
N이 1이면 prime[0]은 없음

result 가 N보다 작다면
end를 증가

크다면
start를 증가

같다면 answer 1증가하고
start와 end를 동시에 증가
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

isPrime = [True] * (N+1)

for i in range(2, int(N ** 0.5)+1):
    if isPrime[i]:
        for j in range(i, N):
            if i*j <= N:
                isPrime[i*j] = False

prime = []
for i in range(2, N+1):
    if isPrime[i]:
        prime.append(i)

if N == 1:
    print(0)
else:
    start = 0
    end = 0
    length = len(prime)
    result = prime[0]
    answer = 0
    while start <= end:
        if result > N:
            result -= prime[start]
            start += 1
        elif result < N:
            end += 1
            if end == length:
                break
            result += prime[end]
        else:
            answer += 1
            result -= prime[start]
            start += 1
            end += 1
            if end == length:
                break
            result += prime[end]

    print(answer)