from collections import deque


def solution(maps):
    dr = [0, -1, 0, 1]
    dc = [1, 0, -1, 0]

    print(1)

    R = len(maps)
    C = len(maps[0])

    for r in range(R):
        for c in range(C):
            if maps[r][c] == 'S':
                startR = r
                startC = c
            elif maps[r][c] == 'L':
                leverR = r
                leverC = c
            elif maps[r][c] == 'E':
                exitR = r
                exitC = c

    def isValid(y, x):
        return 0 <= y and y < R and 0 <= x and x < C

    def bfs(beginR, beginC, targetR, targetC):
        q = deque()
        dist = [[-1] * C for _ in range(R)]

        q.append(beginR)
        q.append(beginC)
        dist[beginR][beginC] = 0

        while q:
            currentR = q.popleft()
            currentC = q.popleft()

            if currentR == targetR and currentC == targetC:
                return dist[currentR][currentC]

            for i in range(4):
                nr = currentR + dr[i]
                nc = currentC + dc[i]
                if isValid(nr, nc):
                    if dist[nr][nc] == -1 and maps[nr][nc] != 'X':
                        q.append(nr)
                        q.append(nc)
                        dist[nr][nc] = dist[currentR][currentC] + 1

        return -1

    ans1 = bfs(startR, startC, leverR, leverC)
    ans2 = bfs(leverR, leverC, exitR, exitC)

    if ans1 == -1 or ans2 == -1:
        return -1
    else:
        return ans1 + ans2

