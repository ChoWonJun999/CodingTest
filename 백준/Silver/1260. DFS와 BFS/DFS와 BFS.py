from collections import deque

def dfs(graph, v, visited):
    visited[v] = True
    print(v, end=' ')
    if len(graph[v]) > 0:
        for i in sorted(graph[v]):
            if not visited[i]:
                dfs(graph, i, visited)


def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True

    while queue:
        v = queue.popleft()
        print(v, end=' ')
        if len(graph[v]) > 0:
            for i in sorted(graph[v]):
                if not visited[i]:
                    queue.append(i)
                    visited[i] = True

                
n, m, v = map(int, input().split())

graph = {v:[]}
visited = {v:False}
for _ in range(m):
    s, e = map(int, input().split())
    if s in graph:
        graph[s].append(e)
    else:
        graph[s] = [e]
        visited[s] = False
    if e in graph:
        graph[e].append(s)
    else:
        graph[e] = [s]
        visited[e] = False

dfs(graph, v, visited.copy())
print()
bfs(graph, v, visited.copy())