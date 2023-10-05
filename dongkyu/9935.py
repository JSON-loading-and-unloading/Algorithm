import sys
from collections import deque


def solve(s, b):
    stack = deque()
    n, m = len(s), len(b)
    burst = deque(b)
    for i in range(n):
        stack.append(s[i])
        if stack and stack[-1] == b[-1] and len(stack) >= len(b):
            temp = deque()
            for _ in range(m):
                temp.appendleft(stack.pop())
            if temp != burst:
                stack.extend(temp)
    return ''.join(stack) if len(stack) > 0 else 'FRULA'


S = sys.stdin.readline().strip()
B = sys.stdin.readline().strip()
print(solve(S, B))
