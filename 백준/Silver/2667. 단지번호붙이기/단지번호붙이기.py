from collections import deque


def bfs(g, v, visit):
    cnt = 1
    que = deque([v])
    visit[v] = True

    while que:
        v = que.popleft()
        for i in g[v]:
            if not visit[i]:
                que.append(i)
                visit[i] = True
                cnt += 1

    return cnt


n = int(input())
arr = [[0]*n for _ in range(n)]
for i in range(n):
    data = input()
    for j in range(n):
        arr[i][j] = int(data[j])

graph = [[] for _ in range(n*n)]
visited = [False] * (n*n)
for i in range(n):
    for j in range(n):
        if not arr[i][j]:
            continue
        graph[i * n + j].append(i * n + j)
        if i > 0 and arr[i - 1][j]:
            graph[i * n + j].append((i - 1) * n + j)
        if j < n - 1 and arr[i][j + 1]:
            graph[i * n + j].append(i * n + (j + 1))
        if i < n - 1 and arr[i + 1][j]:
            graph[i * n + j].append((i + 1) * n + j)
        if j > 0 and arr[i][j - 1]:
            graph[i * n + j].append(i * n + (j - 1))

result = []
for i, (g, v) in enumerate(zip(graph, visited)):
    if g and not v:
        result.append(bfs(graph, i, visited))

print(len(result))
for r in sorted(result):
    print(r)
