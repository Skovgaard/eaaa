// Lav en class StringStack med tilhørende push() og pop() metoder.

class StringStack {
    #array = [];
    push(s) {
        if (typeof s === 'string') this.#array.push(s);
        else throw new Error('Type not a string')
    };
    pop() { return this.#array.pop() };
    toString() { return this.#array }
}

let ss = new StringStack();

ss.push('test');
ss.push('test1');
// ss.push(1);
ss.push('test2');
console.log(ss.toString());
console.log(ss.pop());
console.log(ss.toString());