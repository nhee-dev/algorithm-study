N, D = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
road = [i for i in range(D + 1)]

for i in range(D + 1):
    road[i] = min(road[i], road[i - 1] + 1)

    for s, e, len in arr:
        if i == s and e <= D and road[i] + len < road[e]:
            road[e] = road[i] + len

print(road[D])