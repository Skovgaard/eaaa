// Valider med et RegExp, at en tekststreng kun indeholder nogle positive heltal, adskilt med komma.

let regex = /^([1-9]\d*,)*[1-9]\d*$/;

let string1 = 'test';
let string2 = '0';
let string3 = '1,2,3,4,50';
let string4 = '-1';
let string5 = '7';
let string6 = 'daw7,6';

console.log(regex.test(string1));
console.log(regex.test(string2));
console.log(regex.test(string3));
console.log(regex.test(string4));
console.log(regex.test(string5));
console.log(regex.test(string6));