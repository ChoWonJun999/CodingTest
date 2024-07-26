from collections import deque

def bfs(g, v, visit):
    cnt = 0
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
m = int(input())

graph = [[] for _ in range(n)]
visited = [False] * n
for i in range(m):
    s, e = map(int, input().split())
    s -= 1
    e -= 1
    if e not in graph[s]:
        graph[s].append(e)
    if s not in graph[e]:
        graph[e].append(s)
        
if m != 0:
    print(bfs(graph, 0, visited))
else:
    print(0)