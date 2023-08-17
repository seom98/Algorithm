import math

def is_square_number(num):
    sqrt = int(math.sqrt(num))
    return sqrt * sqrt == num

N = int(input())
sum_value = 0

# N이 제곱수일 경우
if is_square_number(N):
    print(-1)
else:
    # N이 빗변인 경우
    # 검사해야할 범위는 루트N/루트2 만큼임.
    for i in range(1, int(math.sqrt(N * 2) / 2) + 1):
        j = N - i * i
        if is_square_number(j):
            sum_value += 1
            
    # N이 빗변이 아닌 경우
    # -> N = B^2 - A^2
    # -> N = (B+A)(B-A)
    # 두 수의 곱이면 약수로 볼 수도 있다.
    # ex) 8 = 8*1, 4*2
    # B+A, B-A 전부 짝수이거나 홀수이어야 함.
    # ex) 4 = 3+1, 2 = 3-1;
    # 둘 다 짝수이거나, 홀수이면 둘을 더했을 때 항상 짝수가 나옴.
    for i in range(1, int(math.sqrt(N)) + 1):
        if N % i == 0:
            if (i + (N // i)) % 2 == 0:
                sum_value += 1

    print(sum_value)
