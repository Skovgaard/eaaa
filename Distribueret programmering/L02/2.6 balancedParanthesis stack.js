// Lav en string variabel der indeholder noget kode med nogle parenteser – (), {} og []. 
// Lav dernæst en funktion, der skal afgøre, om parenteserne i koden er balancerede.
// Som datastruktur anvendes en stak (et array). Når der mødes en venstre parenteser i koden, 
// skal den sættes på stakken – og når der mødes en højre parentes, skal det kontrolleres, 
// om den tilsvarende venstre parentes er øverst på stakken. Brug metoderne push() og pop().

let stringVariable = 'm(){return list[0]}';
let stringVariable2 = 'm(){return list[0])}';

function balancedParanthesis(string) {
    let stack = [];

    for (let e of string) {
        if (e == '(' || e == ('{') || e == ('['))
            stack.push(e);

        if (e == ')' || e == ('}') || e == (']')) {
            if (e == ')' && stack.pop() != '(')
                return false;
            else if (e == '}' && stack.pop() != '{')
                return false;
            else if (e == ']' && stack.pop() != '[')
                return false;
        }
    }
    return true;
}

console.log(balancedParanthesis(stringVariable));
console.log(balancedParanthesis(stringVariable2));