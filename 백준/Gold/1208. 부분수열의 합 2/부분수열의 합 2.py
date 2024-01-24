"""
완전탐색시 모든 부분집합을 구한다
그럼 2^40 대강 1000^4 시간초과

백트래킹으로 시간줄이기
수열을 정렬해두고

1. 앞에서부터 더해나가면서 이미 S에 도달했다면 뒤의 경우는 안보기
2. S를 넘었다면 뒤의 경우는 안보기
3. 지금 값부터 양의 값들을 아무리 더해도 S가 되지 않는다면 뒤의 경우는 안보기

시간초과

수열을 반으로 나눠서 풀기
그럼 시간복잡도는 2 * 2^20
"""
import sys
from collections import defaultdict

input = lambda: sys.stdin.readline().strip()

N, S = map(int, input().split())
lst = list(map(int, input().split()))

lst1 = lst[:N//2]
lst2 = lst[N//2:]


def recur1(cur, total):
    if cur == len(lst1):
        int_dict[total] += 1
        return
    selected[cur] = False
    recur1(cur + 1, total)
    selected[cur] = True
    recur1(cur + 1, total + lst1[cur])


def recur2(cur, total):
    if cur == len(lst2):
        global answer
        answer += int_dict[S - total]
        return
    selected[cur] = False
    recur2(cur + 1, total)
    selected[cur] = True
    recur2(cur + 1, total + lst2[cur])


selected = [False] * N
int_dict = defaultdict(int)
recur1(0, 0)

answer = 0
selected = [False] * N
recur2(0, 0)

if S == 0:
    answer -= 1
print(answer)