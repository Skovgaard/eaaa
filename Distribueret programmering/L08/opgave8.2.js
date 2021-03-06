// Definer en compareSort funktion, der tager en compare funktion som parameter 
// og returnerer en sort funktion, der bruger denne compare funktion til at sortere et array.

let a = ['cdwa', 'Bf', 'adw'];

function compareSort(compare) {
    return (array) => array.sort(compare);
}

// Brug compareSort funktionen til at generere en lenSort og en ignoreCaseSort funktion, 
// der bruger compareLen hhv. compareIgnoreCase fra opgave 2.3.

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

let lenSort = compareSort(compareLen);
let ignoreCaseSort = compareSort(compareIgnoreCase);

console.log(a);
lenSort(a);
console.log(a);

console.log(a);
ignoreCaseSort(a);
console.log(a);