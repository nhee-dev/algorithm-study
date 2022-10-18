N, M = map(int, input().split())
xCut = [0, N]; yCut = [0, M]

for _ in range(int(input())):
    check, num = map(int, input().split())
    if check == 0:
        yCut.append(num)
    elif check == 1:
        xCut.append(num)

xCut.sort(); yCut.sort()
xSize = ySize = 0

for i in range(len(xCut)-1):
    if xSize < xCut[i+1]-xCut[i]:
        xSize = xCut[i+1]-xCut[i]

for i in range(len(yCut)-1):
    if ySize < yCut[i+1]-yCut[i]:
        ySize = yCut[i+1]-yCut[i]

print(xSize * ySize)