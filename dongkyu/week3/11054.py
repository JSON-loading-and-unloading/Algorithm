# n^2log(n)

import bisect
import sys


def lis(p_dp, value, middle):
    if value < middle:
        if p_dp[-1] < value:
            p_dp.append(value)
        else:
            idx = bisect.bisect_left(p_dp, value)
            p_dp[idx] = value


def go(n, arr):
    result = 0
    for i in range(1, n + 1):
        dp = [0]
        for j in range(1, i):
            lis(dp, arr[j], arr[i])

        r_dp = [0]
        for j in range(n, i, -1):
            lis(r_dp, arr[j], arr[i])

        result = max(result, len(dp) + len(r_dp) - 1)
    return result


n = int(sys.stdin.readline())
arr = [0] + list(map(int, sys.stdin.readline().split(" ")))
print(go(n, arr))
