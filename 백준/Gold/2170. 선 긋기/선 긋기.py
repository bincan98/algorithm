"""
그리디

배열을 정렬하고 순서대로 길이에 더하기
"""
import sys

input = lambda: sys.stdin.readline().strip()

N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

arr = sorted(arr)

answer = arr[0][1] - arr[0][0]
last = arr[0][1]
for x, y in arr[1:]:
    if x <= last < y:
        answer += y - last
        last = y
    elif last <= x:
        answer += y - x
        last = y

print(answer)