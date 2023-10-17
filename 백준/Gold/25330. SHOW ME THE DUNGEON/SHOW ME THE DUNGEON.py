"""
부분집합으로 가능한 경우를 모두 찾는다
(공집합은 제외)

만들어지면 오름차순으로 정렬
(공격력이 가장 작은걸 뒤로 보내기 위함)

체력이 얼마나 깍이는지 계산한뒤 사용자의 체력과 비교해서
답에 넣거나 넣지 않음
"""
import sys

input = lambda: sys.stdin.readline().strip()

N, K = map(int, input().split())
monster = list(map(int, input().split()))
npc = list(map(int, input().split()))

lst = []
for i in range(N):
    lst.append([monster[i], npc[i]])

lst = sorted(lst)


def validate(arr):
    total = 0
    cnt = len(arr)
    return_value = 0
    for i in range(len(arr)):
        total += cnt * arr[i][0]
        cnt -= 1
        return_value += arr[i][1]

    if K >= total:
        return return_value

    return 0


def recur(cur, arr):
    if cur == N:
        if len(arr) == 0:
            return
        global answer
        answer = max(answer, validate(arr))
        return
    recur(cur + 1, arr + [lst[cur]])
    recur(cur + 1, arr)


answer = 0
recur(0, [])
print(answer)