"""
x^2

(x-1)^2

2x-1 >= 100,000

x >= 50,000.5

50,001개의 check 배열을 만들어서 풀어도 되지만, 투포인터를 써보자

각 자연수의 제곱 차는 수가 커질수록 커진다

start 를 1, end 를 2로 설정하고

start의 제곱과 end의 제곱의 차가 G보다 크다면
start를 1증가

작다면
end를 1증가

같다면
answer 배열에 end를 넣고
start와 end를 1 증가
"""

import sys

input = lambda: sys.stdin.readline().strip()

G = int(input())

answer = []

start = 1
end = 2

while start < end:
    if int(end ** 2) - int(start ** 2) > G:
        start += 1
    elif int(end ** 2) - int(start ** 2) < G:
        end += 1
    else:
        answer.append(end)
        start += 1
        end += 1

if answer:
    for a in answer:
        print(a)
else:
    print(-1)