def solution(queue1, queue2):
    queue3 = queue1 + queue2
    
    target = sum(queue3)//2
    
    start = 0
    end = len(queue1)-1
    
    sumValue = sum(queue1)
    cnt = 0
    isSuccess = False
    while start <= end:
        if sumValue < target:
            end += 1
            if end == len(queue3):
                break
            sumValue += queue3[end]
            cnt += 1
        elif sumValue > target:
            sumValue -= queue3[start]
            start += 1
            cnt += 1
        else:
            isSuccess = True
            break
    if isSuccess:
        answer = cnt
    else:
        answer = -1
    return answer