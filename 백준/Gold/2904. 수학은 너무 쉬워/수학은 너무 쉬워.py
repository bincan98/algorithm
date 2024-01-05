"""
정수론

점수는 종이에 적혀있는 모든 수의 최대공약수

즉 N개의 수들의 소인수를 균일하게 펴바른수가 점수

N개를 돌면서 소인수들의 개수를 구하고 개수를 N으로 나누었을때 몫들의 곱이 점수일 것

N개의 수들의 소인수 개수들중에 점수를 만드는데 부족한 소인수의 개수들이 행동을 카운트개수일 것

메모리초과

N개의 수들의 소인수를 저장하기 위해 1_000_000짜리 리스트를 만들었으나 너무 큼

N개의 defaultdict(int)를 선언하는걸로 대체
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N = int(input())

arr = [defaultdict(int) for _ in range(N)]
int_dict = defaultdict(int)

lst = list(map(int, input().split()))

for a in range(N):
    for i in range(2, int(lst[a] ** 0.5) + 1):
        while lst[a] % i == 0:
            int_dict[i] += 1
            arr[a][i] += 1
            lst[a] //= i
    if lst[a] != 1:
        int_dict[lst[a]] += 1
        arr[a][lst[a]] += 1

prime_factors = defaultdict(int)
answer = 1
for a in int_dict:
    if int_dict[a] // N > 0:
        answer *= (a ** (int_dict[a] // N))
        prime_factors[a] = int_dict[a] // N

cnt = 0
for prime_factor in prime_factors:
    for a in arr:
        if a[prime_factor] < prime_factors[prime_factor]:
            cnt += (prime_factors[prime_factor] - a[prime_factor])

print(answer, cnt)
