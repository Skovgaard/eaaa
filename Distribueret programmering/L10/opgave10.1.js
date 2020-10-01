// Tag udgangspunkt i specialisering.js og tilføj equals() metoder samt en compare() metode.
// Metoden equals(p) på Person skal sikre, at p har Person som constructor og har samme navn som personen.
// Metoden equals(s) på Studerende skal sikre, at s har Studerende som constructor 
// og har samme navn og id som den studerende.
// Den static compare(p1, p2) skal sammenligne p1 og p2 baseret på navn.
// Lav dernæst et array med nogle personer og studerende og sorter dem på navn. 
// Indsæt desuden et par katte (se polymorfi.js) og sorter på ny.

// specialisering.js
class Person {
    constructor(navn) {
        this.navn = navn;
    }
    equals(p) { return p.constructor.name === 'Person' && this.navn === p.navn }
    static compare(p1, p2) { return p1.navn.localeCompare(p2.navn); }
    toString() { return this.navn; }
}
class Studerende extends Person {
    constructor(navn, id) {
        super(navn);
        this.id = id;
    }
    equals(s) { return s.constructor.name === 'Studerende' && this.navn === s.navn && this.id === s.id }
    toString() { return super.toString() + ": " + this.id; };
}
let person = new Person("Viggo");
let studerende = new Studerende("Ida", 123);
console.log(person instanceof Person); // => true
console.log(person instanceof Studerende); // => false
console.log(studerende instanceof Person); // => true
console.log(studerende instanceof Studerende); // => true


let person2 = new Person("Messi");
let person3 = new Person("Coutinho");
let studerende2 = new Studerende("De Jong", 124);
let studerende3 = new Studerende("Fati", 122);
let person4 = new Person("Messi");

let array = [person, person2, person3, person4, studerende, studerende2, studerende3];
console.log(array);
array.sort(Person.compare);
console.log(array);
console.log(person4.equals(person4));
console.log(person4.equals(person2));

class Kat {
    constructor(navn) {
        this.navn = navn;
    }
    toString() { return super.toString() + ": " + this.navn; };
}

let kat = new Kat('Kat');
let kat2 = new Kat('Garfield');

array.push(kat);
array.push(kat2);
array.sort(Person.compare);
console.log(array);