// Lav et array med en række person objekter. Hver person skal have et navn, 
// en alder og et mobilnummer. Løs nedenstående vha. arrays højere ordens metoder.

let array = [
    { navn: 'bnavn1', alder: 1, mobilnummer: '11111111' },
    { navn: 'anavn2', alder: 10, mobilnummer: '22222222' },
    { navn: 'cnavn3', alder: 100, mobilnummer: '33333333' }
];

// Find person med et bestemt mobilnummer.

let result = array.filter(element => element.mobilnummer == '22222222'); // Kunne bruge find
console.log(result);

// Find den mindste alder.

result = array.map(element => element.alder).reduce((akkumulator, element) => Math.min(akkumulator, element));
console.log(result);

// Modificer arrayet med personer, så personerne nu får et fortløbende id.

let id = 0;
array.forEach(element => element.id = id++);
console.log(array);

// Generer en tekststreng, der indeholder personernes navne – kommasepareret 
// og i sorteret rækkefølge. 

let string = '';
array.sort((a, b) => {
    if (a.navn < b.navn) {
        return -1;
    }
    if (a.navn > b.navn) {
        return 1;
    }
    return 0;
}).forEach(element => string += element.navn + ',');
console.log(string);
// Kunne mappe på navn or sortere

// Generer et array med navn og mobilnummer på de personer, der er yngre end 30.

let newArray = [];
result = array.filter(element => element.alder < 30).forEach(element => newArray.push({ navn: element.navn, mobilnummer: element.mobilnummer }));
console.log(newArray);