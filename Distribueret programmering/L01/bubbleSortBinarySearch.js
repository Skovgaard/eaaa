let list = [7, 13, 9, 8, 4, 1, 2, 16, 0];

for (let i = list.length - 1; i >= 0; i--) {
    for (let j = 0; j <= i - 1; j++) {
        if (list[j] > list[j + 1]) {
            let temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
        }
    }
}
console.log(list.toString()); // => 0,1,2,4,7,8,9,13,16

function binarySearch(t) {
    let l = 0, r = list.length - 1;
    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (list[m] < t)
            l = m + 1;
        else if (list[m] > t)
            r = m - 1;
        else
            return m;
    }
    return -1;
}

console.log(binarySearch(1));
console.log(binarySearch(7));
console.log(binarySearch(13));
console.log(binarySearch(77));