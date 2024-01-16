import sys

input = lambda: sys.stdin.readline().strip()

for i in range(int(input())):
    if input() == "anj":
        print("뭐야;")
        exit()

print("뭐야?")