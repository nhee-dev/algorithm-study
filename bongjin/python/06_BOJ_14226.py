from collections import deque
N = int(input())
v = dict()
v[(1, 0)] = 0
q = deque()
q.append((1, 0))

while q:
    s, c = q.popleft()
    if s == N:
        print(v[(s, c)])
        break

    if(s, s) not in v.keys():
        v[s, s] = v[(s, c)] + 1
        q.append((s, s))
    if(s - 1, c) not in v.keys():
        v[(s - 1, c)] = v[(s, c)] + 1
        q.append((s - 1, c))
    if(s + c, c) not in v.keys():
        v[(s + c, c)] = v[(s, c)] + 1
        q.append((s + c, c))
