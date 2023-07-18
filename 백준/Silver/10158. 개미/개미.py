import sys

input_lines = sys.stdin.read().strip().split('\n')
len = list(map(int, input_lines[0].split()))
start = list(map(int, input_lines[1].split()))
sec = int(input_lines[2])
aaa = ""

for i in range(2):
    A = sec - (len[i] - start[i])
    ans = 0
    if A <= 0:
        ans = start[i] + sec
    else:
        if A // len[i] % 2 == 0:
            ans = len[i] - (A % len[i])
        else:
            ans = A % len[i]
    aaa += f"{ans} "

print(aaa)