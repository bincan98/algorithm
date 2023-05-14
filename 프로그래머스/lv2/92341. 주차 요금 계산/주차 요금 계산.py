from collections import defaultdict
import math

def solution(fees, records):

    # 입차된 차량 시각을 저장할 사전
    parking = defaultdict(int)
    # 출차된 뒤 시간을 더해줄 사전
    parkingTime = defaultdict(int)

    # 입출차 기록 살피기
    for record in records:
        # 만약 입차라면
        if record[11:] == "IN":
            # 차량 번호를 key로 시각과 분을 저장하기 (시각*100 + 분)
            parking[record[6:10]] = int(record[:2]) * 100 + int(record[3:5]) 
        else: # 만약 출차라면
            # 입차된 시각은 저장된시간 // 100
            startHour = parking[record[6:10]] // 100
            # 입차된 분은 저장된 시간 % 100
            startMinute = parking[record[6:10]] % 100
            # 출차된 시각은 지금 살피는 기록의 0부터 1까지의 인덱스
            endHour = int(record[:2])
            # 출차된 분은 지금 살피는 기록의 3부터 4까지의 인덱스
            endMinute = int(record[3:5])
            # 차량 번호를 key로 시간을 구해서 넣기
            parkingTime[record[6:10]] += (endHour - startHour) * 60 + (endMinute - startMinute)
            # 새로 그전의 입차기록은 초기화
            parking[record[6:10]] = -1

    # 입차된 후에 출차된 내역이 있는지 확인하기
    for key, value in parking.items():
        # 출차 내역이 없다면
        if value != -1:
            # 출차 시간을 23시 59분으로 똑같이 시간 구해서 넣어주기
            startHour = int(parking[key]) // 100
            startMinute = int(parking[key]) % 100
            endHour = 23
            endMinute = 59
            parkingTime[key] += (endHour - startHour) * 60 + (endMinute - startMinute)

    # key인 차량번호 순으로 정렬하기
    parkingTime = sorted(parkingTime.items())
    # 정답 배열
    answer = []
    for _, time in parkingTime:
        sum = 0
        # 기본시간을 넘었다면
        if time >= fees[0]:
            # 기본요금 부과
            sum += fees[1]
            # 기본 시간 빼주기
            time -= fees[0]
        else: # 넘지 않았다면
            # 기본요금 answer에 넣고 다음 차량 보기
            answer.append(fees[1])
            continue
        # 나머지 시간 계산해서 요금 부과하고 answer에 넣어주기
        sum += math.ceil(time / fees[2]) * fees[3]
        answer.append(sum)


    return answer

