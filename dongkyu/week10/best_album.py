import heapq as hq
from collections import defaultdict


def solution(genres, plays):
    answer = []
    counter, plays_dict = defaultdict(int), defaultdict(list)
    for i in range(len(plays)):
        counter[genres[i]] += plays[i]
        hq.heappush(plays_dict[genres[i]], (-plays[i], i))

    for genre, total in sorted(counter.items(), key=lambda x: x[1], reverse=True):
        for _ in range(2):
            if plays_dict[genre]:
                answer.append(hq.heappop(plays_dict[genre])[1])
    return answer
