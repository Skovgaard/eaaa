let startTime = Date.now();
console.log(printPrimes(1000));
console.log(`${Date.now() - startTime} ms`);

startTime = Date.now();
console.log(printPrimesOptimized(1000));
console.log(`${Date.now() - startTime} ms`);

function printPrimes(n) {
    let result = [];

    if (n >= 2)
        result.push(2) // 2 er speciel

    for (let i = 2; i <= n; i++) {
        for (let j = 2; j < i; j++) {
            if (i % j == 0)
                break;
            if (j == i - 1)
                result.push(i);
        }
    }

    return result;
}

function printPrimesOptimized(n) {
    let result = [];

    if (n >= 2)
        result.push(2) // 2 er speciel

    for (let i = 2; i <= n; i++) {
        for (let j = 0; j < result.length; j++) {
            if (i % result[j] == 0)
                break;
            if (j > Math.sqrt(i) || j == result.length - 1) {
                result.push(i);
                break;
            }
        }
    }

    return result;
}