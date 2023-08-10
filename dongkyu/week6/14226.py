import sys


def solve(s):
    dp = [0] * (s + 1)
    for i in range(1, s + 1):
        dp[i] = i
        for j in range(i - 1, 0, -1):
            count = j
            time = 1
            while count < i:
                count += j
                time += 1
            time += (count - i)
            dp[i] = min(dp[i], dp[j] + time)
    return dp[s]


s = int(sys.stdin.readline())
print(solve(s))
