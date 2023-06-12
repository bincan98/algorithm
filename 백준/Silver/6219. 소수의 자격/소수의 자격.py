"""
에라토스테네스의 체로 소수 표시하는 자료구조 만들기

그리고 해당하는 수가 있는지 체크하기
"""

A, B, D = map(int, input().split())

isPrime = [True] * (B+1)

isPrime[1] = False
for i in range(2, B):
    if isPrime[i]:
        for j in range(2, B):
            if i*j > B:
                break
            isPrime[i*j] = False
# print(*isPrime)
answer = 0
for i in range(A, B+1):
    if isPrime[i]:
        N = i
        while N:
            if N % 10 == D:
                answer += 1
                break
            N //= 10
print(answer)