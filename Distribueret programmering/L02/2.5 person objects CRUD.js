// Lav et array med en række person objekter.
// Hver person skal have et navn, en e-mail og et mobilnummer.
// Afprøv CRUD på dette arrayet som vist på siden CRUD på arrays i arrays.pdf.

let personA = {navn: 'a', email: 'a@a.a', mobilnummer: 1};
let personB = {navn: 'b', email: 'b@b.b', mobilnummer: 2};
let personC = {navn: 'c', email: 'c@c.c', mobilnummer: 3};

let persons = [personA, personB, personC];

console.log(persons);

let personD = {navn: 'd', email: 'd@d.d', mobilnummer: 4};

persons.push(personD);

persons[0].efternavn = 'aaa';

delete persons[2];

console.log(persons);