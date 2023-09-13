import math
from collections import defaultdict


def solution(clothes):
    cloth_dict = defaultdict(lambda: 1)
    for cloth, type_ in clothes:
        cloth_dict[type_] += 1
    return math.prod([cloth_dict[t] for t in cloth_dict.keys()]) - 1
