import math

a = list(input())

first = a[0]
count = 0
for i in range(1,len(a)):
  if a[i-1] != a[i]:
    count += 1

print(math.ceil(count/2))