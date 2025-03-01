# tc O(m+n), sc O(1).
# Mathematical approach
if m == 1 or n == 1:
    return 1
def factorial(x):
    res = 1
    for num in range(1, x+1):
        res = res * num
    return res

return factorial(m+n-2) // factorial(m-1) // factorial(n-1)