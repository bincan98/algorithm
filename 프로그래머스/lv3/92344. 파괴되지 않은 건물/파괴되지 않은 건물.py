def solution(board, skill):
    n = len(board)
    m = len(board[0])

    imos_2d = [[0] * (m + 1) for _ in range(n + 1)]

    for type, r1, c1, r2, c2, degree in skill:
        if type == 1:
            imos_2d[r1][c1] -= degree
            imos_2d[r1][c2 + 1] += degree
            imos_2d[r2 + 1][c1] += degree
            imos_2d[r2 + 1][c2 + 1] -= degree
        else:
            imos_2d[r1][c1] += degree
            imos_2d[r1][c2 + 1] -= degree
            imos_2d[r2 + 1][c1] -= degree
            imos_2d[r2 + 1][c2 + 1] += degree

    for i in range(n + 1):
        for j in range(1, m + 1):
            imos_2d[i][j] += imos_2d[i][j - 1]

    for j in range(m + 1):
        for i in range(1, n + 1):
            imos_2d[i][j] += imos_2d[i - 1][j]

    answer = 0
    for i in range(n):
        for j in range(m):
            board[i][j] += imos_2d[i][j]
            if board[i][j] > 0:
                answer += 1

    return answer