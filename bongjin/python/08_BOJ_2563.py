N = int(input())
arr = [[0] * 100 for _ in range(100)]
result = 0
for i in range(N):
    x, y = map(int, input().split())
    for j in range(x, x + 10):
        for k in range(y, y + 10):
            arr[j][k] = 1

for row in arr:
    if 1 in row:
        result += sum(row)
print(result)