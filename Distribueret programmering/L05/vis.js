// Opgave 5.1
// Skriv kode i vis.js, der indsætter et <label> element foran hvert <input> element i vis.html. 
// De to labels skal have teksten "Tal: " hhv. "Tid: ". Når der klikkes på en label 
// eller det tilhørende tekstfelt, skal der vises et tilfældigt tal hhv. det aktuelle tidspunkt 
// i tekstfeltet.

let tal = document.getElementById('tal');
tal.outerHTML = '<label for="tal">Tal:</label>' + tal.outerHTML;

let tid = document.getElementById('tid');
tid.outerHTML = '<label for="tid">Tid:</label>' + tid.outerHTML;


tal = document.getElementById('tal');
tal.onclick = () => tal.value = parseInt(Math.random() * 1000);

tid = document.getElementById('tid');
tid.onclick = () => tid.value = new Date().toLocaleTimeString();

let button = document.querySelector('button');
button.onclick = () => {
    tal.value = '';
    tid.value = '';
};