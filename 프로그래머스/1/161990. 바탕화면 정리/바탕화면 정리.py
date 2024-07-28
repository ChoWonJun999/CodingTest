def solution(wallpaper):
    answer = [51, 51, -1, -1]
    for i in range(len(wallpaper)):
        data = wallpaper[i]
        for j in range(len(data)):
            if data[j] == "#":
                answer[0] = answer[0] if answer[0] < i else i
                answer[1] = answer[1] if answer[1] < j else j
                answer[2] = answer[2] if answer[2] > i else i+1
                answer[3] = answer[3] if answer[3] > j else j+1
    return answer