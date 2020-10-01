// Anvendes der polymorfi i Observer pattern – jf. Opgave 8.4?

// Opgave 8.4
function subject() {
    let observers = [];
    return {
        registerObserver: function (observer) { observers.push(observer) },
        notifyObservers: function (p) { observers.forEach(observer => observer(p)) }
    };
}

let subjectTest = subject();

subjectTest.registerObserver((p) => console.log(p));
subjectTest.registerObserver(() => console.log(2 + 2));
// console.log(subjectTest.observers);

subjectTest.notifyObservers('test');

// Ja - det skal bare være en function