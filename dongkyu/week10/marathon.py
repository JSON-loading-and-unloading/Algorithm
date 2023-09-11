from collections import Counter


def solution(participant, completion):
    return ''.join((Counter(participant) - Counter(completion)).keys())
