def solution(numbers):
    
    # 0인 경우 처리
    if max(numbers) == 0:
        return "0"
    
    # 자기자신 반복한 수 넣어놓을 배열 선언
    #[0]은 반복한수 [1]은 4(최대자릿수) - 원래자릿수
    numbers2 = []
    for number in numbers:
        sub = 4 - len(str(number))
        # 새로운 수
        newNumber = number
        # 숫자 끝에 자기자신 숫자 붙여주기
        for i in range(sub):
            newNumber = newNumber * 10 + int(str(number)[i % len(str(number))])
        numbers2.append([newNumber, sub])
    
    # 배열 내림차순으로 정렬
    numbers2.sort(reverse = True)
    
    # 정답 문자열
    answer = ""
    for number in numbers2:
        if number[1] == 0: # 붙인 수가 없다면 그대로 넣기
            answer += str(number[0])
        else: # 붙인수가 있다면
            # 붙인 횟수만큼 자르고 answer에 넣기
            answer += str(number[0] // (10 ** number[1]))
    
    return answer