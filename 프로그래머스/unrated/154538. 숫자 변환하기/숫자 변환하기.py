def solution(x, y, n):
    
    
    
    def isValid(x):
        return 0<=x<y+1
    
    dp = [1_000_000] * (y+1)
    
    dp[x] = 0
    
    for i in range(x+1, y+1):
        tmp = 1_000_000
        if isValid(i-n) and dp[i-n] != 1_000_000:
            tmp = min(tmp, dp[i-n])
        if i % 2 == 0 and isValid(i//2) and dp[i//2] != 1_000_000:
            tmp = min(tmp, dp[i//2])
        if i % 3 == 0 and isValid(i//3) and dp[i//3] != 1_000_000:
            tmp = min(tmp, dp[i//3])
        if tmp != 1_000_000:
            dp[i] = tmp + 1
        
    # print(dp)
    return -1 if dp[y] == 1_000_000 else dp[y]