// Modificer løsningen til opgave 1.3, så algoritmerne nu pakkes ind i funktioner med signaturerne:
// • bubbleSort(array)
// • binarySearch(array, element)
// Gør desuden swap-delen af bubbleSort til en lokal funktion swap(i, j).

function bubbleSort(array) {
    for (let i = array.length - 1; i >= 0; i--) {
        for (let j = 0; j <= i - 1; j++) {
            if (array[j] > array[j + 1]) {

                function swap(i, j) {
                    let temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                swap(j, j + 1);

                // let temp = array[j];
                // array[j] = array[j + 1];
                // array[j + 1] = temp;
            }
        }
    }
}

function binarySearch(array, element) {
    let l = 0, r = array.length - 1;
    while (l <= r) {
        let m = Math.floor((l + r) / 2);
        if (array[m] < element)
            l = m + 1;
        else if (array[m] > element)
            r = m - 1;
        else
            return m;
    }
    return -1;
}

let array = [7, 13, 9, 8, 4, 1, 2, 16, 0];

bubbleSort(array);

console.log(array.toString());

console.log(binarySearch(array, 1));
console.log(binarySearch(array, 7));
console.log(binarySearch(array, 100));