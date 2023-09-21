import sys


def solve(n):
    mxdp, mndp = [0, 0, 0], [0, 0, 0]
    for i in range(n):
        a, b, c = map(int, input().split())
        mx0 = a + max(mxdp[0], mxdp[1])
        mx1 = b + max(mxdp[0], mxdp[1], mxdp[2])
        mx2 = c + max(mxdp[1], mxdp[2])

        mn0 = a + min(mndp[0], mndp[1])
        mn1 = b + min(mndp[0], mndp[1], mndp[2])
        mn2 = c + min(mndp[1], mndp[2])
        mxdp, mndp = [mx0, mx1, mx2], [mn0, mn1, mn2]
    return max(mxdp), min(mndp)


N = int(sys.stdin.readline())
print(' '.join(map(str, solve(N))))
