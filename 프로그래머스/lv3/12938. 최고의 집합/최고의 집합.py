def solution(n, s):
    if n > s:
        return [-1]
    
    answer = [s//n] * n
    
    index = n-1
    for _ in range(s % n):
        answer[index] += 1
        index -= 1
        
    return answer