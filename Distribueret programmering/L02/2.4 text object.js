// Lav en string variabel med en længere tekst.
// Anvend dernæst et objekt som en map til at beregne antallet af de forskellige ord i teksten.
// Brug metoden split() til at opdele teksten i ord.

let text = 'Lav en string variabel med en længere tekst. string en tekst';

let textObject = {
    keys: [],
    values: []
};

let textArray = text.split(' ');

for (let i = 0; i < textArray.length; i++){
    if (!textObject.keys.includes(textArray[i])){
        textObject.keys.push(textArray[i]);
        textObject.values.push(1);
    } else {
        let index = textObject.keys.indexOf(textArray[i]);
        textObject.values[index] += 1;
    }
}

console.log(textObject);