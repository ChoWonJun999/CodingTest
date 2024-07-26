def solution(s):
    split_str = list(map(int, s.split(" ")))
    return f"{min(split_str)} {max(split_str)}"