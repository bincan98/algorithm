def solution(board, skill):
    # 행과 열 값 저장하기
    n = len(board)
    m = len(board[0])

    # 2차원 imos 로 쓸 배열 선언하기 (뒤에  0으로 padding 붙이기)
    imos_2d = [[0] * (m + 1) for _ in range(n + 1)]

    # skill 하나씩 보기
    for type, r1, c1, r2, c2, degree in skill:
        # 공격이라면
        if type == 1:
            # 각 위치에 degree만큼 더하고 빼주기
            imos_2d[r1][c1] -= degree
            imos_2d[r1][c2 + 1] += degree
            imos_2d[r2 + 1][c1] += degree
            imos_2d[r2 + 1][c2 + 1] -= degree
        else: # 수비라면
            # 각 위치에 degree만큼 더하고 빼주기
            imos_2d[r1][c1] += degree
            imos_2d[r1][c2 + 1] -= degree
            imos_2d[r2 + 1][c1] -= degree
            imos_2d[r2 + 1][c2 + 1] += degree

    # 오른쪽으로 쭉 더하기
    for i in range(n + 1):
        for j in range(1, m + 1):
            imos_2d[i][j] += imos_2d[i][j - 1]
    
    # 아래로 쭉 더하기
    for j in range(m + 1):
        for i in range(1, n + 1):
            imos_2d[i][j] += imos_2d[i - 1][j]

    answer = 0
    # board에 imos 값 더해주고 파괴되지 않았는지 체크하기
    for i in range(n):
        for j in range(m):
            board[i][j] += imos_2d[i][j]
            if board[i][j] > 0:
                answer += 1

    return answer