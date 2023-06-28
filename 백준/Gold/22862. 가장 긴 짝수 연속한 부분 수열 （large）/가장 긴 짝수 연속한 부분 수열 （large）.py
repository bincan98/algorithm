"""
나름 인치웜?

처음 홀수를 K개 만큼 포함하는 최대의 수열까지 나아간다

그리고 하나씩 다가 홀수를 빼면 그만 빼고 다음 홀수가 나오기 직전까지 또 나아가기
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

# 배열 입력받기
lst = list(map(int, input().split()))

start = 0
end = 0

answer = 0
result = 0
cnt_odd = 0
# 처음 나아가기
for i in range(N):
    if lst[i] % 2 == 0:
        end += 1
        result += 1
    else:
        if cnt_odd == K:
            end -= 1
            answer = max(answer, result)
            break
        else:
            end += 1
            cnt_odd += 1
    if i == N-1:
        answer = max(answer, result)

while end < N:
    if lst[start] % 2 == 0:
        start += 1
        result -= 1
    else:
        start += 1
        cnt_odd -= 1
        end += 1
        while end < N:
            if lst[end] % 2 == 0:
                end += 1
                result += 1
            else:
                if cnt_odd == K:
                    end -= 1
                    answer = max(answer, result)
                    break
                else:
                    end += 1
                    cnt_odd += 1
    if end == N:
        answer = max(answer, result)

print(answer)