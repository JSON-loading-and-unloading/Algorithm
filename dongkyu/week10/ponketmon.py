def solution(nums):
    answer = 0
    k = len(nums) // 2
    types = len(set(nums))
    return types if types <= k else min(types, k)
