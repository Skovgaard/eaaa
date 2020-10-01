// Valider en dato på formen 31/8 2020 med et RegExp. 
// Det kan antages, at alle måneder kan have 31 dage og at årstallet er i dette århundrede.

// Ikke rigtig - læs opgaven! (Århundrede og tjek evt. at dato ikke er 0)
let regex = /^[\d]{1,2}\/[\d]{1,2}\s\d{4}$/;

let string1 = '31/8 2020';
let string2 = '312/8 2020';
let string3 = '31/8 a2020';

console.log(regex.test(string1));
console.log(regex.test(string2));
console.log(regex.test(string3));
