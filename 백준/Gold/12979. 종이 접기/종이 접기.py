"""
A의 약수가 가능한 가로 세로 길이임
A의 모든 약수를 구하고 모든 경우를 따져보자

만약 모든 경우에서 w나 h보다 높은 길이가 있다면 불가능한 경우이다

한곳을 접어도 최대 절반으로만 길이가 줄어드는 걸 이용
(홀수일 경우를 위해서 +1 하고 //2 하기)

길이를 줄였을때 본래의도한 길이와 같거나 작아진다면 만들수 있는것
"""
import sys

input = lambda: sys.stdin.readline().strip()


def find_divisors(x):
    lst = []
    for i in range(1, int(x ** 0.5) + 1):
        if x % i == 0:
            lst.append(i)
            if i * i != x:
                lst.append(x // i)
    return lst


W, H, A = map(int, input().split())

A_divisors = find_divisors(A)

answer = 987654321
for a in A_divisors:
    target_W = a
    target_H = A // a
    tmp_W = W
    tmp_H = H
    cnt = 0
    if W < target_W or H < target_H:
        continue
    while tmp_W > target_W:
        tmp_W = (tmp_W + 1) // 2
        cnt += 1
    while tmp_H > target_H:
        tmp_H = (tmp_H + 1) // 2
        cnt += 1
    answer = min(answer, cnt)

if answer == 987654321:
    print(-1)
else:
    print(answer)