// Implementer en dobbeltrettet associering mellem Person og en class Gruppe, som i PRO1.

// Person 0..* -- 1 Gruppe
class Person {
    constructor(navn, gruppe) {
        this.navn = navn;
        this.gruppe = gruppe;
        gruppe.tilføjPerson(this);
    }
    toString() { return ' navn: ' + this.navn };
}

class Gruppe {
    constructor(navn) {
        this.navn = navn;
        this.personer = [];
    }
    tilføjPerson(p) { this.personer.push(p) };
    toString() { return this.navn + ' [' + this.personer.toString() + ' ]' }
}

let gruppe = new Gruppe('Gruppe 1');

let person1 = new Person('Navn 1', gruppe);
let person2 = new Person('Navn 2', gruppe);

console.log(gruppe.toString());
console.log(person1.gruppe.navn);
console.log(person1.gruppe);