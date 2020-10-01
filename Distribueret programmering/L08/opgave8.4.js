// Implementer et Observer pattern på følgende måde:
// • Observers implementeres som funktioner, der kaldes, når de ”notifies”.
// • Et Subject defineres som en subject funktion, der har et array med observers som lokal variabel
// • Funktionen subject skal desuden definere funktionerne registerObserver og notifyObservers som
//   indre funktioner og returnere dem som metoder i et object. 
// Afprøv implementationen med et par observers.

function subject() {
    let observers = [];
    return {
        registerObserver: function (observer) { observers.push(observer) },
        notifyObservers: function () { observers.forEach(observer => observer()) }
    };
}

let subjectTest = subject();

subjectTest.registerObserver(() => console.log('test'));
subjectTest.registerObserver(() => console.log(2 + 2));
console.log(subjectTest.observers);

subjectTest.notifyObservers();