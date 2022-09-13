t = int(input())
score = list(map(int, input().split()))
score.sort(reverse=True)
m = score[0]

for i in range(0, len(score)):
    score[i] = score[i] / m * 100

print(sum(score) / len(score))