"""
start 와 end 가 딱 붙으면 안된다 그럼 0

만일 end+1 이 end 보다 크거나 같다면
end 1 증가시키기

작다면
start 1 증가시키기
 만약 start와 end가 딱 붙는다면 start 대신 end 증가시키기

 계속 틀린다

 그럼 start 를 0으로 end 를 N-1 로 두고 생각해보자

 어차피 카운트는 줄어든다
 그럼 min 만 보면 된다

start 와 min 중에 작은걸 땡기자
왜냐하면 그건 답이 될 수가 없기 때문이다
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

lst = list(map(int, input().split()))

if N == 2:
    print(0)
else:
    start = 0
    end = N-1
    answer = (end-start-1)*min(lst[start], lst[end])

    while start < end:
        if lst[start] >= lst[end]:
            end -= 1
            answer = max(answer, (end-start-1)*min(lst[start], lst[end]))
        else:
            start += 1
            answer = max(answer, (end-start-1) * min(lst[start], lst[end]))

    print(answer)