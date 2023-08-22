def solution(picks, minerals):
    answer = 987654321
    
    n = 0
    if len(minerals) % 5 == 0:
        n = len(minerals) // 5
    else:
        n = len(minerals) // 5 + 1
    n = min(n, sum(picks))
    
    selected = [-1] * n
    
    def cacul(pick, mineral):
        if pick == 0: # 다이아곡괭이
            return 1
        elif pick == 1: # 철곡괭이
            if mineral == "diamond":
                return 5
            else:
                return 1
        else: # 돌곡괭이
            if mineral == "diamond":
                return 25
            elif mineral == "iron":
                return 5
            else:
                return 1
            
    def recur(cur):
        if cur == n:
            nonlocal answer
            result = 0
            for i in range(n):
                for j in range(i*5, i*5+5):
                    if j >= len(minerals):
                        break
                    result += cacul(selected[i], minerals[j])
            answer = min(answer, result)
            return
        for i in range(3):
            if picks[i] == 0:
                continue
            picks[i] -= 1
            selected[cur] = i
            recur(cur + 1)
            picks[i] += 1
    
    recur(0)
    
    return answer

