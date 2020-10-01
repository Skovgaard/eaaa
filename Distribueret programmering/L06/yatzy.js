// Yatzy mini-projekt
// Author: Kasper Skovgaard

// EVENTS

// Results onclick event
const resultOnclick = event => {
    if (event.target == focus) {
        event.target.style.outline = 'none';
        focus = null;
        if (turnCounter == 3)
            document.querySelector('#roll').disabled = true;
    } else {
        if (focus != null) focus.style.outline = 'none';
        event.target.style.outline = '2px solid blue';
        focus = event.target;
        document.querySelector('#roll').disabled = false;
    }
}

// Roll button onclick
function rollDies() {
    let dieImgs = document.querySelectorAll('#dices input');
    for (let i = 0; i < Object.keys(dies).length; i++) {
        if (focus != null) {
            dies[i].holds = false;
            dieImgs[i].style.opacity = 1;
        }
        if (!dies[i].holds) {
            dies[i].value = getRandomInt(6) + 1;
            dieImgs[i].src = `res/die${dies[i].value}.png`;
        }
    }
    document.getElementById('turn').textContent = `Turn: ${++turnCounter}`;
    if (turnCounter == 3)
        document.querySelector('#roll').disabled = true;
    if (focus != null) {
        focus.disabled = true;
        focus.style.outline = 'none';
        ids[focus.id].locked = true;
        ids[focus.id].value = parseInt(focus.value);
        focus = null;
        turnCounter = 1;
        document.querySelector('#turn').textContent = `Turn: ${turnCounter}`;
    }
    // Update results
    let results = getResults();
    updateResults(results);

    // Update GUI
    document.querySelector('#sum').value = results[6];
    document.querySelector('#total').value = results[17];

    // Check if game is over
    if (remainingInResults() == 0)
        gameOver(results);
}


// GENERAL JAVASCRIPT

let turnCounter = 0;
let focus = null;

const dies = {
    0: { value: 1, holds: false },
    1: { value: 1, holds: false },
    2: { value: 1, holds: false },
    3: { value: 1, holds: false },
    4: { value: 1, holds: false }
}

const ids = {
    ones: { tekst: '1-s', value: 0, locked: false, onclick: resultOnclick },
    twos: { tekst: '2-s', value: 0, locked: false, onclick: resultOnclick },
    threes: { tekst: '3-s', value: 0, locked: false, onclick: resultOnclick },
    fours: { tekst: '4-s', value: 0, locked: false, onclick: resultOnclick },
    fives: { tekst: '5-s', value: 0, locked: false, onclick: resultOnclick },
    sixes: { tekst: '6-s', value: 0, locked: false, onclick: resultOnclick },
    sum: { tekst: 'Sum', value: 0, locked: true },
    bonus: { tekst: 'Bonus', value: 50, locked: true },
    onepair: { tekst: 'One pair', value: 0, locked: false, onclick: resultOnclick },
    twopair: { tekst: 'Two pairs', value: 0, locked: false, onclick: resultOnclick },
    threesame: { tekst: 'Three same', value: 0, locked: false, onclick: resultOnclick },
    foursame: { tekst: 'Four same', value: 0, locked: false, onclick: resultOnclick },
    fullhouse: { tekst: 'Full house', value: 0, locked: false, onclick: resultOnclick },
    smallstraight: { tekst: 'Small straight', value: 0, locked: false, onclick: resultOnclick },
    largestraight: { tekst: 'Large straight', value: 0, locked: false, onclick: resultOnclick },
    chance: { tekst: 'Chance', value: 0, locked: false, onclick: resultOnclick },
    yatzy: { tekst: 'Yatzy', value: 0, locked: false, onclick: resultOnclick },
    total: { tekst: 'Total', value: 0, locked: true }
}

function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

// GUI

createGUI();

function createGUI() {
    // Creating divs for borders and content
    const yatzy = document.getElementById('yatzy');
    yatzy.innerHTML += '<div id="dices" class="border"></div>';
    yatzy.innerHTML += '<div id="results" class="border"></div>';

    // Creating dices
    const dices = document.getElementById('dices');

    for (let index = 0; index < 5; index++) {
        const element = document.createElement('input');
        element.id = `die${index}`;
        element.className = 'die';
        element.type = 'image';
        element.src = 'res/die1.png';
        element.onclick = event => {
            dies[index].holds = !dies[index].holds;
            if (dies[index].holds)
                element.style.opacity = 0.4;
            else
                element.style.opacity = 1;
        }
        dices.append(element);
    }

    // Creating turn counter
    const turn = document.createElement('p');
    turn.id = 'turn';
    turn.textContent = 'Turn: 0';
    dices.append(turn);

    // Creating roll button
    const roll = document.createElement('button');
    roll.id = 'roll';
    roll.textContent = 'Roll!';
    roll.onclick = event => rollDies();
    dices.append(roll);

    // Creating labels and inputs in results
    let resultsElements = document.getElementById('results');
    for (const key in ids) {
        if (ids.hasOwnProperty(key)) {
            const t = ids[key].tekst;
            const v = ids[key].value;
            resultsElements.innerHTML += `<label for="${key}">${t}</label>`;
            resultsElements.innerHTML += `<input type="number" id="${key}" value="${v}" readonly>`;
        }
    }

    // Editing sum, bonus and total inputs to disabled
    document.querySelector('#sum').disabled = true;
    document.querySelector('#bonus').disabled = true;
    document.querySelector('#total').disabled = true;

    // Creating onclick events in results 
    const inputs = document.querySelectorAll('#results input');
    let index = 0;
    for (const key in ids) {
        if (ids.hasOwnProperty(key)) {
            const element = ids[key];
            inputs[index++].onclick = element.onclick;
        }
    }
}

// Update results
function updateResults(results) {
    const resultsElements = document.querySelectorAll('#results input');
    for (let i = 0; i < resultsElements.length; i++) {
        if (!ids[resultsElements[i].id].locked)
            resultsElements[i].value = results[i];
    }
}

// Reset gui
function resetGUI() {
    const yatzy = document.getElementById('yatzy');
    yatzy.innerHTML = '';
    createGUI();
}

// GAME LOGIC

// Used in both calcSum and calcTotal
const idsArray = Object.keys(ids);

function calcSum() {
    let sum = 0;
    for (let i = 0; i < 6; i++) {
        if (ids[idsArray[i]].locked) {
            sum += ids[idsArray[i]].value;
        }
    }
    ids[idsArray[6]].value = sum;
    return sum;
}

function calcTotal() {
    let total = 0;
    total += ids[idsArray[6]].value;
    if (ids[idsArray[6]].value >= 63)
        total += ids[idsArray[7].id].value;
    for (let i = 8; i < idsArray.length - 1; i++) {
        if (ids[idsArray[i]].locked) {
            total += ids[idsArray[i]].value;
        }
    }
    ids[idsArray[17]].value = total;
    return total;
}

// Results logic 
function getResults() {
    let results = [];
    for (let i = 0; i < 6; i++) {
        results[i] = sameValuePoints(i + 1);
    }
    results[6] = calcSum();
    results[7] = 0;
    results[8] = onePairPoints();
    results[9] = twoPairPoints();
    results[10] = samePoints(3);
    results[11] = samePoints(4);
    results[12] = fullHousePoints();
    results[13] = smallStraightPoints();
    results[14] = largeStraightPoints();
    results[15] = chancePoints();
    results[16] = yatzyPoints();
    results[17] = calcTotal();
    return results;
}

function frequency() {
    const freq = [0, 0, 0, 0, 0, 0, 0];
    for (let i = 0; i < Object.keys(dies).length; i++) {
        freq[dies[i].value]++;
    }
    return freq;
}

// Same value points
function sameValuePoints(value) {
    let sum = 0;
    for (let i = 0; i < Object.keys(dies).length; i++) {
        if (dies[i].value == value)
            sum += value;
    }
    return sum;
}

// Pairs
function onePairPoints() {
    let freq = frequency();
    for (let i = 6; i > 0; i--) {
        if (freq[i] >= 2)
            return i * 2;
    }
    return 0;
}

function twoPairPoints() {
    const freq = frequency();
    let startNumber = (onePairPoints() / 2) - 1;
    for (let i = startNumber; i > 0; i--) {
        if (freq[i] >= 2)
            return onePairPoints() + (i * 2);
    }
    return 0;
}

// Sames
function samePoints(amount) {
    const freq = frequency();
    for (let i = 1; i < freq.length; i++) {
        if (freq[i] >= amount)
            return i * amount;
    }
    return 0;
}

// Full house
function fullHousePoints() {
    const freq = frequency();
    for (let i = 0; i < freq.length; i++) {
        if (freq[i] == 2 && samePoints(3) != 0) {
            return i * 2 + samePoints(3);
        }
    }
    return 0;
}

// Small straight
function smallStraightPoints() {
    const freq = frequency();
    for (let i = 1; i < freq.length - 1; i++) {
        if (freq[i] != 1) {
            return 0;
        }
    }
    return 15;
}

// Large straight
function largeStraightPoints() {
    const freq = frequency();
    for (let i = 2; i < freq.length; i++) {
        if (freq[i] != 1) {
            return 0;
        }
    }
    return 20;
}

// Chance
function chancePoints() {
    let sum = 0;
    for (let i = 0; i < Object.keys(dies).length; i++) {
        sum += dies[i].value;
    }
    return sum;
}

// Yatzy
function yatzyPoints() {
    const freq = frequency();
    for (let i = 1; i < freq.length; i++) {
        if (freq[i] == 5) {
            return 50;
        }
    }
    return 0;
}

// Game over pop up
function gameOver(results) {
    let restart = confirm(`Score: ${results[17]}\nStart nyt spil?`);
    if (restart) {
        resetLogic();
        resetGUI();
    }
}

// Remaining fields
function remainingInResults() {
    let counter = Object.keys(ids).length;
    for (const obj in ids) {
        if (ids[obj].locked)
            counter--;
    }
    return counter;
}

// Reset logic
function resetLogic() {
    // Reset dies
    for (const key in dies) {
        if (dies.hasOwnProperty(key)) {
            const element = dies[key];
            element.value = 1;
            element.holds = false;
        }
    }
    // Reset ids
    for (const key in ids) {
        if (ids.hasOwnProperty(key)) {
            const element = ids[key];
            // Values
            if (element.tekst == 'Bonus')
                element.value = 50;
            else
                element.value = 0;
            // Locked
            if (element.tekst == 'Sum' || element.tekst == 'Bonus' || element.tekst == 'Total')
                element.locked = true;
            else
                element.locked = false;
        }
    }
    // Reset rollcount and focus
    turnCounter = 0;
    focus = null;
}




/*

Noter:

Har bevist ikke kodet meget i html filen - ligesom divx eksemplet
Har forsøgt at bruge både innerHTML og createElement()
Check " " vs '
Check let vs const
Man kan starte et spil ved at vælge et antal point før man har rullet
Ikke helt tilfreds med løsning for onclick events i result, men det virker fint
De 2 events er lidt rodet, overvejde et sætte dem op se gui og js logic var opdelt
Der hvor jeg disabler sum, bonus og total kunne jeg også bare have gjort det hvor jeg opretter alle fra ids.
Dog svært pga. innerhtml metoden frem for den anden.
Smart med at bruge samme id/navne i både html og i ids objektet.

*/