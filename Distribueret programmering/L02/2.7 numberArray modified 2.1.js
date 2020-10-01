// Lav et array med tal.
// Modificer dernæst max(), contains() og sum() funktionerne fra opgave 2.1, 
// så de bliver metoder på dette array.

let numberArray = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

numberArray.max = function(){
    let max = -Infinity;
    for (let i = 0; i < this.length; i++) {
        if (this[i] > max) max = this[i];
    }
    return max;
};

console.log(numberArray.max());

numberArray.contains = function(element) {
    for (let i = 0; i < this.length; i++) {
        if (this[i] == element) return true;;
    }
    return false;
}

console.log(numberArray.contains(7));
console.log(numberArray.contains(10));

numberArray.sum = function() {
    let sum = 0;
    for (let i = 0; i < this.length; i++) {
        sum += this[i];
    }
    return sum;
}

console.log(numberArray.sum());