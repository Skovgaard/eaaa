const MOUNTAINS = [
    { name: "Kilimanjaro", height: 5895, place: "Tanzania" },
    { name: "Everest", height: 8848, place: "Nepal" },
    { name: "Mount Fuji", height: 3776, place: "Japan" },
    { name: "Vaalserberg", height: 323, place: "Netherlands" },
    { name: "Denali", height: 6168, place: "United States" },
    { name: "Popocatepetl", height: 5465, place: "Mexico" },
    { name: "Mont Blanc", height: 4808, place: "Italy/France" }
];

let table = document.getElementById('mountains').innerHTML;

table += '<tr>';
for (let iterator of Object.keys(MOUNTAINS[0])) {
    table += `<th>${iterator}</th>`;
}
table += '</tr>';

for (const iterator of MOUNTAINS) {
    table += '<tr>';
    for (let element of Object.values(iterator)) {
        table += `<td>${element}</th>`;
    }
    table += '</tr>';
}

document.getElementById('mountains').innerHTML = table;

document.getElementById('mountains').style.border = '3px solid blue';
document.getElementById('mountains').style.borderCollapse = 'collapse';

list = document.getElementsByTagName('td');
for (const iterator of list) {
    iterator.style.border = '3px solid blue';
    iterator.style.borderCollapse = 'collapse';
    if (!isNaN(iterator.textContent))
        iterator.style.textAlign = 'right';
}