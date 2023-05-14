from collections import defaultdict
import math

def solution(fees, records):

    parking = defaultdict(int)
    parkingTime = defaultdict(int)

    for record in records:
        # print(record[11:])
        if record[11:] == "IN":
            parking[record[6:10]] = int(record[:2]) * 100 + int(record[3:5])
        else: # OUT이면
            startHour = int(parking[record[6:10]]) // 100
            startMinute = int(parking[record[6:10]]) % 100
            endHour = int(record[:2])
            endMinute = int(record[3:5])
            parkingTime[record[6:10]] += (endHour - startHour) * 60 + (endMinute - startMinute)
            parking[record[6:10]] = -1

    for key, value in parking.items():
        if value != -1:
            startHour = int(parking[key]) // 100
            startMinute = int(parking[key]) % 100
            endHour = 23
            endMinute = 59
            parkingTime[key] += (endHour - startHour) * 60 + (endMinute - startMinute)


    # print(parking)
    # print(parkingTime)

    parkingTime = sorted(parkingTime.items())

    # print(parkingTime)

    answer = []
    for _, time in parkingTime:
        sum = 0
        if time >= fees[0]:
            sum += fees[1]
            time -= fees[0]
        else:
            sum += fees[1]
            answer.append(sum)
            continue
        sum += math.ceil(time / fees[2]) * fees[3]
        answer.append(sum)


    return answer

