def solution(m, n, puddles):
    maps = [[False] * (m + 1) for _ in range(n + 1)]

    for puddle in puddles:
        maps[puddle[1]][puddle[0]] = True

    disCnt = [[0] * (m + 1) for _ in range(n + 1)]

    disCnt[1][1] = 1

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if not maps[i - 1][j]:
                disCnt[i][j] += disCnt[i - 1][j] % 1000000007
            if not maps[i][j - 1]:
                disCnt[i][j] += disCnt[i][j - 1] % 1000000007

    return disCnt[n][m] % 1000000007
