// Svarende til Java’s Comparator#compare(...) metode, skal der her laves nogle compare-funktioner, 
// der tager to parametre, og returnerer -1, 0 eller 1 alt efter om den første parameter er mindre 
// end, lig med eller større en den anden parameter.
// Der skal laves følgende compare-funktioner:
// • compare(s1, s2): Sammenligner de to tekststrenge leksikografisk.
// • compareLen(s1, s2): Sammenligner de to tekststrenge på deres længde
// • compareIgnoreCase(s1, s2): Sammenligner to tekststrenge leksikografisk uden at tage hensyn til
// store og små bogstaver
// Modificer dernæst bubbleSort funktionen fra opgave 2.2, så den nu får en compare-funktion som ekstra
// parameter. Sammenligningen i bubbleSort funktionen skal nu ske med denne compare-funktion.

function compare(s1, s2) {
    if (s1 < s2) return -1;
    else if (s1 > s2) return 1;
    else return 0;
}

function compareLen(s1, s2) {
    if (s1.length < s2.length) return -1;
    else if (s1.length > s2.length) return 1;
    else return 0;
}

function compareIgnoreCase(s1, s2) {
    if (s1.toLowerCase() < s2.toLowerCase()) return -1;
    else if (s1.toLowerCase() > s2.toLowerCase()) return 1;
    else return 0;
}

console.log(compare("aaa", "bbb"));
console.log(compare("bbb", "aaa"));
console.log(compare("aaa", "aaa"));

console.log(compareLen("aaa", "bbb"));
console.log(compareLen("aaa", "bbbb"));

console.log(compareIgnoreCase("aaa", "AAA"));

function bubbleSort(array, compareFunction) {
    for (let i = array.length - 1; i >= 0; i--) {
        for (let j = 0; j <= i - 1; j++) {
            if (compareFunction(array[j], array[j + 1]) > 0) {

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

let array = [7, 13, 9, 8, 4, 1, 2, 16, 0];

bubbleSort(array, compare);

console.log(array.toString());