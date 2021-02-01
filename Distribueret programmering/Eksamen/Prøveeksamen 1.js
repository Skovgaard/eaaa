const array = [
    { navn: 'Åge', kast: [3, 1, 2] },
    { navn: 'Ida', kast: [6, 2, 4] },
    { navn: 'Ida', kast: [1, 3, 5] }
];

function kast(navn, array) {
    return array.filter(e => e.navn === navn).map(e => e.kast)
}

function størst(array) {
    return array.map(e => e.kast.reduce((a, e) => a > e ? a : e))
}

function terninger(json) {
    const array = []
    return json.match(/[1-6]/g)
}

function navne(json) {
    const regex = /:"(.+?)"/g
    let matched
    let array = []
    while (matched = regex.exec(json)) {
        let navn = matched[1]
        if (!array.includes(navn))
            array.push(navn)
    }
    return array
}

console.log(kast('Ida', array));
console.log(kast('Åge', array));

console.log(størst(array));

const json = JSON.stringify(array)

console.log(json);

console.log(terninger(json));

console.log(navne(json));