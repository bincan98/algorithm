n = int(input())

cnt = 0
ele = []
for i in range(2, int(n ** 0.5)+1):
    while n % i == 0:
       cnt += 1
       ele.append(i)
       n = n // i
if n != 1:
    ele.append(n)
    cnt += 1

print(cnt)
print(*ele)