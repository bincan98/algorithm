"""
start 와 end 를 0으로 두고
result 를 lst[0] 으로 둔다

result 가 S 이상이라면
현재의 길이를 answer 에 넣어보고
start 를 1 증가시킨다
(end를 증가시켜도 S 이상이고 answer 는 최소로 바뀌지 않을테니)

S 보다 작다면
end 를 1 증가시킨다
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, S = map(int, input().split())

lst = list(map(int, input().split()))

answer = 100_000

start = 0
end = 0
result = lst[0]
length = 1

while start <= end:
    if result >= S:
        answer = min(answer, length)
        result -= lst[start]
        start += 1
        length -= 1
    else:
        end += 1
        if end == N:
            break
        result += lst[end]
        length += 1

if answer == 100_000:
    print(0)
else:
    print(answer)