def recur(cur, total):
	global ans
	if cur == n:
		if total == k:
			ans += 1
		return
	recur(cur + 1, total + ls[cur])
	recur(cur + 1, total)

n, k = map(int, input().split())
ls = list(map(int, input().split())) 
ans = 0
recur(0, 0)
print(ans - int(k == 0))