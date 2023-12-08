import sys

input = sys.stdin.readline
sys.setrecursionlimit( 10 ** 8)

def dfs(now):
  for nxt in range(n):
    if adj[now][nxt] == 1 and not chk[nxt]:
      chk[nxt] = True
      dfs(nxt)

n, m = map(int, input().split())

adj = [ [0] * n for _ in range(n)]
chk = [False] * n 
ans = 0

for i in range(m):
  a, b =map(int, input().split())
  adj[a-1][b-1] = 1
  adj[b-1][a-1] = 1

for i in range(n):
  if not chk[i]:
    chk[i] = True
    ans += 1
    dfs(i)
    
print(ans)