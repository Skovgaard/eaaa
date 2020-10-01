// Programmer nedenstående funktioner, hvor array indeholder nogle tal:
// • max(array): returnerer det største element i arrayet.
// • contains(array, element): returnerer true hvis elementet findes i arrayet, ellers false
// • sum(array): returnerer summen af elementerne i arrayet.

function max(array) {
    let max = -Infinity;
    for (let i = 0; i < array.length; i++) {
        if (array[i] > max) max = array[i];
    }
    return max;
}

function contains(array, element){
    for (let i = 0; i < array.length; i++) {
        if (array[i] == element) return true;;
    }
    return false;
}

function sum(array){
    let sum = 0;
    for (let i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
}

let array = [1, 2, 3, 4, 5];

console.log(max(array));

console.log(contains(array, 4));
console.log(contains(array, 6));

console.log(sum(array));