// Tilføj kode for opgave 4.1 - 4.5 her!
// Opgave 4.1
// Giv alle afsnit en rød tekstfarve ved brug af opgaver.css.
let list = document.getElementsByTagName('p');
for (let iterator of list) {
    iterator.style.color = 'red';
}

// Opgave 4.2
// Giv det andet element efter hver overskrift en brun farve.
list = document.body.children;
for (let iterator of list) {
    if (iterator.tagName == 'H1') {
        let secondElement = iterator.nextElementSibling.nextElementSibling;
        secondElement.style.color = 'brown';
    }
}

// Opgave 4.3
// Giv hvert andet element i listen en lysegrå baggrundsfarve.
list = document.getElementsByTagName("li");
let counter = 0;
for (let iterator of list) {
    if (counter % 2 == 0)
        iterator.style.backgroundColor = 'lightgrey';
    counter++;
}

// Opgave 4.4
// Find første afsnit lige efter hver overskrift og gør det til en underoverskrift.
list = document.body.children;
for (let iterator of list) {
    if (iterator.tagName == 'H1') {
        let element = iterator.nextElementSibling.outerHTML;
        element = element.replace('<p', '<h2');
        element = element.replace('</p', '</h2');
        iterator.nextElementSibling.outerHTML = element;
    }
}

// Opgave 4.5
// Giv hver overskrift et id og indsæt et link til hver overskrift øverst på websiden.
// Brug et internt link på formen <a href="#xyz "> ... </a>, hvor xyz er id for en overskrift.
list = document.body.children;
document.body.innerHTML = '<div id="links"></div>' + document.body.innerHTML;
let idCounter = 0;
for (let iterator of list) {
    if (iterator.tagName == 'H1' || iterator.tagName == 'H2'){
        iterator.id = idCounter;
        document.getElementById('links').innerHTML += `<a href='#${idCounter}'> ${iterator.innerText}<br></a>`;
        idCounter++;
    }
}
