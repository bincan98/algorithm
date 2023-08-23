"""
백트로 풀자

기저조건은 total이 n이면 스탑

1, 2, 3의 개수를 계속 들고 다니다가
기저조건 만나면 answer에 넣기

그리고 answer 정렬하고 맞는거 빼기
"""
import sys

input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())

lst = [0, 1, 2, 4]

for i in range(4, 11):
    lst.append(lst[i-1] + lst[i-2] + lst[i-3])

answer = []


def recur(arr, total):
    if total > n:
        return
    if total == n:
        answer.append(arr)
        return
    recur(arr + [1], total + 1)
    recur(arr + [2], total + 2)
    recur(arr + [3], total + 3)


if k > lst[n]:
    print(-1)
else:
    recur([], 0)
    answer = sorted(answer)
    print('+'.join(map(str, answer[k-1])))