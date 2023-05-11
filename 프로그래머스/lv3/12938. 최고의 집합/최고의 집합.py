def solution(n, s):
    # 만약 s가 n보다 작다면 집합을 만들 수 없는 경우
    if n > s:
        return [-1]
    
    # s를 n으로 나눈 몫으로 이루어진 원소 n개의 집합 만들기 
    answer = [s//n] * n
    
    # 인덱스는 맨뒤부터 시작
    index = n-1
    # 나머지 만큼 반복하기
    for _ in range(s % n):
        # 뒤에서부터 1더해주기
        answer[index] += 1
        # 인덱스는 빼주기
        index -= 1
        
    return answer