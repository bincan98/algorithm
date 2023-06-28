"""
두 수의 합과 비슷한 문제이다

이미 오름차순으로 주어진다

둘의 절댓값을 비교해서 큰쪽을 줄인다 그래야 0과 가까워지므로

그전 차보다 적다면 둘을 새로운 정답 배열에 넣을
"""

import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())

# 배열 입력받기
lst = list(map(int, input().split()))

start = 0
end = N-1

answer = []
result = 2_000_000_000
while start < end:
    if abs(lst[start] + lst[end]) <= result:
        result = abs(lst[start] + lst[end])
        answer.clear()
        answer.append(lst[start])
        answer.append(lst[end])
    if abs(lst[start]) > abs(lst[end]):
        start += 1
    elif abs(lst[start]) < abs(lst[end]):
        end -= 1
    else: # 같다면 서로 하나앞의 것들과 비교해보기
        # 범위체크하기
        if start+1 < end-1:
            if abs(lst[start+1]) > abs(lst[end-1]):
                start += 1
            else:
                end -= 1
        else: # 범위체크를 통과하지 못한다면 아무거나 1증가해주기
            start += 1

print(*answer)