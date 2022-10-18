import sys; 
input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
v = [([False] * M) for _ in range(N)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
result = 0
max_val = max(map(max, arr))

def dfs(x, y, len, sum):
    global result
    if result >= sum + max_val * (3 - len):
        return
    if len == 3:
        result = max(result, sum)
        return
    else:
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and v[nx][ny] == 0:
                if len == 1:
                    v[nx][ny] = True
                    dfs(x, y, len + 1, sum + arr[nx][ny])
                    v[nx][ny] = False
                v[nx][ny] = True
                dfs(nx, ny, len + 1, sum + arr[nx][ny])
                v[nx][ny] = False

for i in range(N):
    for j in range(M):
        v[i][j] = 1
        dfs(i, j, 0, arr[i][j])
        v[i][j] = 0

print(result)