"""
로프를 입력받고 정렬하기

가장 작은 수부터 
자신의 중량 * 자신과 자신보다 큰 로프의 개수
를 하면서 max값 찾기
"""
import sys

input = lambda: sys.stdin.readline().strip()

lst = []
N = int(input())
for _ in range(N):
    lst.append(int(input()))

lst = sorted(lst)

max_value = 0
for i in range(N):
    max_value = max(max_value, lst[i] * (N - i))

print(max_value)