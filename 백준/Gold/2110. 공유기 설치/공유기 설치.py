"""
가능한 값을 찾는 매개변수탐색인데 값의 가능여부가 선형태를 띠므로 이분탐색이 가능하다

가장 인접한 두 공유기 사이의 거리는 최소 1 최대 10억이 가능하다

따라서 이걸 이분탐색 해보자

구현부는 deque 쓰기

처음 원소와 이번 "가장 인접한 두 공유기 사이의 거리" 만큼 떨어진 곳을 기준점으로 잡고

그 사이 집들은 큐에서 빼주기

만약 while 문이 끝나고 

q에 원소가 남아있다면 그 거리가 가능하다는 것이고
없다면 거리를 더 짧게 해야한다는 뜻이다
"""
import sys
import math
from collections import deque

input = lambda: sys.stdin.readline().strip()


def valid(distance):
    q = deque(lst)
    cnt = 0
    while cnt < C - 1:
        cnt += 1
        nxt = q[0] + distance
        while q:
            if q[0] < nxt:
                q.popleft()
            else:
                break
        if not q:
            break
    if q:
        return True
    else:
        return False


N, C = map(int, input().split())

lst = []
for i in range(N):
    lst.append(int(input()))

lst = sorted(lst)

start = 0
end = lst[-1] - lst[0]
answer = 0
while start <= end:
    mid = (start + end) // 2
    is_possible = valid(mid)
    if is_possible:
        answer = mid
        start = mid + 1
    else:
        end = mid - 1

print(answer)