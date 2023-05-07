from collections import deque

def solution(maps):
    dy = (0,-1,0,1)
    dx = (1,0,-1,0)

    def isValid(y, x):
        return 0<=y<len(maps) and 0<=x<len(maps[0])

    def bfs(y, x):
        q = deque()

        q.append((y, x))
        visited[y][x] = True

        sum = int(maps[y][x])
        while q:
            currentY, currentX = q.popleft()
            for i in range(4):
                ny = currentY + dy[i]
                nx = currentX + dx[i]
                if isValid(ny,nx) and maps[ny][nx] != 'X' and not visited[ny][nx]:
                    q.append((ny,nx))
                    visited[ny][nx] = True
                    sum += int(maps[ny][nx])

        return sum

    visited = [[False] * len(maps[0]) for _ in range(len(maps))]

    answer = []
    for i in range(len(maps)):
        for j in range(len(maps[0])):
            if not visited[i][j] and maps[i][j] != 'X':
                answer.append(bfs(i, j))

    if answer:
        answer = sorted(answer)
        return answer
    else:
        return [-1]