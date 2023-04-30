from collections import deque

def solution(maps):
    # 갈 수 있는 4방향 저장한 배열
    dr = [0, -1, 0, 1]
    dc = [1, 0, -1, 0]

    # 맵의 크기 저장
    R = len(maps)
    C = len(maps[0])

    # 시작, 레버, 끝 지점의 좌표 구하기
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

    # 인덱스의 범위 체크할 함수
    def isValid(y, x):
        return 0 <= y and y < R and 0 <= x and x < C

    # bfs
    def bfs(beginR, beginC, targetR, targetC):
        # 큐와 걸린시간배열 선언
        q = deque()
        dist = [[-1] * C for _ in range(R)]

        # 시작지점 큐에 넣고 거리 초기화
        q.append(beginR) # r, c 순으로 넣기
        q.append(beginC)
        dist[beginR][beginC] = 0

        while q: # 큐가 차있을때까지 반복
            currentR = q.popleft() # 두개씩 빼기
            currentC = q.popleft()

            # 목표 지점에 왔다면 걸린 시간 반환하기
            if currentR == targetR and currentC == targetC:
                return dist[currentR][currentC]

            # 4가지 방향 모두 체크하기
            for i in range(4):
                nr = currentR + dr[i]
                nc = currentC + dc[i]
                if isValid(nr, nc):
                    if dist[nr][nc] == -1 and maps[nr][nc] != 'X':
                        q.append(nr)
                        q.append(nc)
                        dist[nr][nc] = dist[currentR][currentC] + 1

        # 큐가 다 끝날동안 목표에 못 도착하면 -1 반환
        return -1

    ans1 = bfs(startR, startC, leverR, leverC)
    ans2 = bfs(leverR, leverC, exitR, exitC)
    
    if ans1 == -1 or ans2 == -1: # 둘 중 하나라도 도착을못했다면
        return -1 # -1 반환하기
    else: # 아니라면 둘을 더한 값을 반환하기
        return ans1 + ans2

