"""
지름 구하는법은 제일 먼거리 구하기

중간에 노드가 2개씩이라면 cnt의 마지막 인덱스 * 2이다.

노드가 하나일때 처리하기

7
2 1 2 1 2 1 3
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
cnt = [1] + list(map(int, input().split()))

prev_distance = 0
current_distance = 0
for i in range(1, N + 1):
    prev_distance += 1
    if cnt[i] == 1:
        prev_distance = max(prev_distance, current_distance + 1)
        current_distance = 0
    else:
        current_distance += 2

print(max(prev_distance, current_distance))