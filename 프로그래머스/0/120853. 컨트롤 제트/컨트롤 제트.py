def solution(s):
    answer = 0
    str_split = s.split(" ")
    last = 0
    for char in str_split:
        if char == "Z":
            last = -last
        else:
            last = int(char)
        answer += last
    return answer