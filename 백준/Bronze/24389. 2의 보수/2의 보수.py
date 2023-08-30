import sys

input = lambda: sys.stdin.readline().strip()

binary = [0] * 33
rev_binary = [0] * 33

N = int(input())

i = 0
while N:
    if N % 2 == 1:
        binary[i] = 1
    i += 1
    N //= 2

for i in range(33):
    if binary[i] == 1:
        rev_binary[i] = 0
    else:
        rev_binary[i] = 1

sum = 1
for i in range(32):
    if rev_binary[i] + sum >= 2:
        rev_binary[i] = 0
        sum = 1
    else:
        rev_binary[i] += sum
        break

answer = 0
for i in range(32):
    if binary[i] != rev_binary[i]:
        answer += 1

print(answer)