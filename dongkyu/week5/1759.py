import sys


def search(arr, words, l, c, depth, answer):
    if depth == l:
        vowel_count = sum(sum(letter in 'aeiou' for letter in word) for word in arr)
        if vowel_count >= 1 and l - vowel_count >= 2:
            answer.append(''.join(arr))
        return

    for i in range(c):
        if depth == 0 or (arr[depth] == '' and words[i] > arr[depth - 1]):
            arr[depth] = words[i]
            search(arr, words, l, c, depth + 1, answer)
            arr[depth] = ''


def solve(l, c, words):
    answer = []
    arr = [''] * l
    search(arr, words, l, c, 0, answer)
    answer.sort()
    print('\n'.join(answer))


l, c = map(int, sys.stdin.readline().split(' '))
words = list(sys.stdin.readline().strip().split(' '))
solve(l, c, words)
