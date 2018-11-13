N = int(input())
count = 0
for i in range(1, 500):
    for j in range(1, 500):
        if i * i == j * j + N:
            count += 1

print(count)
