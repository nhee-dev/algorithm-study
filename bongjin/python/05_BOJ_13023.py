import sys;

N, M = map(int, input().split())
arr = [[] for i in range(N)]
v = [False] * N

for _ in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    arr[a].append(b)
    arr[b].append(a)


def find(next, len):
    if len == 4:
        print(1)
        exit()
    for i in arr[len]:
        if not v[i]:
            v[i] = True
            find(next + 1, len)
            v[i] = False


for i in range(N):
    v[i] = True
    find(0, i)
    v[i] = False

print(0)