// Opgave 5.2
// Skriv kode i tabs.js, som viser <p> elementet svarende til det <span> element, 
// der klikkes på. Fra starten skal den første tab vises. Brug CSS display propertien 
// til at vise og skjule indholdet af en tab.

let h2 = document.querySelector('h2');
let h1 = document.querySelectorAll('h1');
let spans = document.querySelectorAll('span');
for (let index = 0; index < spans.length; index++) {
    let element = spans[index];
    element.onclick = () => console.log(element);
    element.onclick = () => {
        for (const iterator of h1) {
            iterator.style.display = 'none';
        }
        h1[index].style.display = 'inline';
    }
}