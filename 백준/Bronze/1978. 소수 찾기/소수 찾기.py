import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
lst = list(map(int, input().split()))

cnt_prime = 0
for a in lst:
    is_prime = True
    if a == 1:
        continue
    for i in range(2, int(a ** 0.5) + 1):
        if a % i == 0:
            is_prime = False
            break
    if is_prime:
        cnt_prime += 1

print(cnt_prime)