// I denne opgave skal der laves en chatklient til browseren.
// Chatserveren findes allerede, og kan tilgås med denne Url: https://dipchat.herokuapp.com/
// Der er følgende GET endpoints:
//  • beskeder – alle chatbeskeder
//  • beskeder/:rum – alle chatbeskeder i et givet chatrum
//  • rum – alle anvendte chatrum
// Der er et POST endpoint:
//  • besked – opretter en ny chatbesked
// Et POST request skal have følgende properties:
//  • navn – navn på afsender
//  • rum – navn på det chatrum, hvor beskeden skal vises
//  • tekst – chatbesked
// Der er også et DELETE endpoint:
//  • besked/:nr – sletter chatbeskeden med det givne nr
// Chatklienten skal kunne skifte mellem at vise alle beskeder og vise beskeder i et bestemt chatrum. 
// De viste beskeder skal opdateres automatisk med passende mellemrum.
// Det skal være muligt at vælge chatrum med et <select> element. Desuden skal det være muligt at oprette og slette beskeder.

let url = 'http://localhost:8080/';

// GET
async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

async function getEndpoint(url, endpoint) {
    try {
        let respons = await get(url + endpoint);
        console.log(endpoint);
        console.log(respons);
        return respons;
    } catch (fejl) {
        console.log(fejl);
    }
}

// getEndpoint(url, 'beskeder');
// getEndpoint(url, 'rum');
// getEndpoint(url, 'beskeder/xxx');

// POST
async function post(url, objekt) {
    const respons = await fetch(url, {
        method: "POST",
        body: JSON.stringify(objekt),
        headers: { 'Content-Type': 'application/json' }
    });
    if (respons.status !== 201) // Created
        throw new Error(respons.status);
    return await respons.json();
}

let chatMessageTestObject = {
    navn: "Kasper",
    rum: "xxx",
    tekst: "test"
};

async function postChatMessage(url, chatMessageObject) {
    try {
        let postBeskedUrl = url + 'besked';
        console.log(postBeskedUrl);

        let respons = await post(postBeskedUrl, chatMessageObject);
        console.log(respons);
    } catch (fejl) {
        console.log(fejl);
    }
}

// postChatMessage(url, chatMessageTestObject);

// DELETE
async function deLete(url) {
    let respons = await fetch(url, {
        method: "DELETE"
    });
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

async function deleteChatMessage(url, nr) {
    try {
        let deleteChatMessageUrl = url + 'besked/' + nr;

        let respons = await deLete(deleteChatMessageUrl);
        console.log(respons);
    } catch (fejl) {
        console.log(fejl);
    }
}

// deleteChatMessage(url, 12);

// GENERATE WEBPAGE
// Loads chat rooms and populates selection + loads messages for chatroom[0]
async function loadChatRooms() {
    const chatrum = document.getElementById('chatrum');

    let alleChatrum = await getEndpoint(url, 'rum');

    chatrum.innerHTML += `<option value="alle rum">Alle rum</option>`;
    loadChatroomMessages('alle rum');

    for (const rum of alleChatrum) {
        chatrum.innerHTML += `<option value="${rum}">${rum}</option>`;
    }
}

loadChatRooms();

// Get chatroom selection and add onchange
const chatrum = document.getElementById('chatrum');
chatrum.onchange = () => loadChatroomMessages(chatrum.value);

// Loads chatroom messages and write on website
async function loadChatroomMessages(room) {

    let beskeder;
    const submit = document.getElementById('submit');
    if (room === 'alle rum') {
        beskeder = await getEndpoint(url, `beskeder`);
        submit.disabled = true;
    } else {
        beskeder = await getEndpoint(url, `beskeder/${room}`);
        submit.disabled = false;
    }

    const chatbox = document.getElementById('chatbox');
    // Scroll to bottom? Not tested
    chatbox.scrollTop = chatbox.scrollHeight;

    chatbox.innerHTML = '';
    for (const besked of beskeder) {
        chatbox.innerHTML += `${besked.navn}: ${besked.tekst} (${besked.nr})<br>`;
    }
}

// Set onclick for submit
const submit = document.getElementById('submit');
submit.onclick = () => submitPostChatMessage();

async function submitPostChatMessage() {
    const navnInput = document.getElementById('navn').value;
    const rumInput = document.getElementById('chatrum').value;
    const tekstInput = document.getElementById('tekst').value;

    let chatMessageObject = {
        navn: navnInput,
        rum: rumInput,
        tekst: tekstInput
    };

    await postChatMessage(url, chatMessageObject);

    // Clear textfield
    document.getElementById('tekst').value = '';

    // Update chat messages
    updateChatroom();
}

function updateChatroom() {
    const chatrum = document.getElementById('chatrum');
    loadChatroomMessages(chatrum.value);
}

// Update chat
setInterval(function () {
    updateChatroom();
}, 1000);

// Set onclick for delete
const del = document.getElementById('delete');
del.onclick = () => submitDeleteChatMessage();

async function submitDeleteChatMessage() {
    const nrInput = document.getElementById('nr').value;

    await deleteChatMessage(url, nrInput);

    // Clear nr field
    document.getElementById('nr').value = '';

    // Update chat messages
    updateChatroom();
}