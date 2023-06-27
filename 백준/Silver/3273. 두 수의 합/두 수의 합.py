import sys

input = lambda: sys.stdin.readline().strip()

n = int(input())
lst = list(map(int, input().split()))
x = int(input())

lst = sorted(lst)

answer = 0
start = 0
end = n-1

while start < end:
    if lst[start] + lst[end] == x:
        answer += 1
        start += 1
        end -= 1
    elif lst[start] + lst[end] < x:
        start += 1
    else:
        end -= 1

print(answer)