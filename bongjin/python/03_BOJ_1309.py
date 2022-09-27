N = int(input())
arr = [[0 for i in range(3)] for j in range(N)]
arr[0][0] = 1
arr[0][1] = 1
arr[0][2] = 1

for i in range(1, N):
    arr[i][0] = arr[i - 1][1] + arr[i - 1][2] % 9901
    arr[i][1] = arr[i - 1][0] + arr[i - 1][2] % 9901
    arr[i][2] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] % 9901

r = (arr[N-1][0] + arr[N-1][1] + arr[N-1][2]) % 9901
print(r)
