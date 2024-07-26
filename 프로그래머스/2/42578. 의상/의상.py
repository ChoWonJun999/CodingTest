def solution(clothes):
    from collections import Counter
    from functools import reduce
    cnt = Counter([kind for name, kind in clothes])
    answer = reduce(lambda x, y: x*(y+1), cnt.values(), 1) - 1
    return answer

# def solution(clothes):
#     answer = 1
#     case = {};
#     for i in clothes:
#         if i[1] in case:
#             case[i[1]] = case.get(i[1]) + 1
#         else:
#             case[i[1]] = 1
#     for i in case.values():
#         answer *= i+1
#     return answer-1