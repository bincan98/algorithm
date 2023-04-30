def solution(m, n, puddles):
    # 웅덩이 저장할 2차원 배열
    maps = [[False] * (m + 1) for _ in range(n + 1)]

    # 웅덩이 저장하기
    for puddle in puddles:
        maps[puddle[1]][puddle[0]] = True

    # 최소거리 저장할 2차원 배열
    disCnt = [[0] * (m + 1) for _ in range(n + 1)]

    # 시작하기
    disCnt[1][1] = 1

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if not maps[i - 1][j]: # 위쪽 좌표가 웅덩이가 아니라면
                disCnt[i][j] += disCnt[i - 1][j] % 1000000007 # 위쪽 방법수 더해주기
            if not maps[i][j - 1]: # 왼쪽 좌표가 웅덩이가 아니라면
                disCnt[i][j] += disCnt[i][j - 1] % 1000000007 # 왼쪽 방법수 더해주기

    return disCnt[n][m] % 1000000007
