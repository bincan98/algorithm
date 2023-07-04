"""
답의 형태가 연속적인 매개변수 탐색이다
따라서 이분탐색의 형태로 변경할 수 있다
"""

import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())

lst = []
for _ in range(N):
    lst.append(int(input()))

answer = 0

# 0ml를 줄 수는 없으므로 1부터 시작
start = 1
end = max(lst)
while start <= end:
    result = 0
    mid = (start + end) // 2
    for ele in lst:
        result += ele // mid
    if result >= K:
        answer = max(answer, mid)
        start = mid + 1
    else:
        end = mid - 1

print(answer)