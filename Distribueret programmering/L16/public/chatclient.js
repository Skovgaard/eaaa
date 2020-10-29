// let url = 'http://localhost:8080/chat/';
let url = 'https://l17-chat.herokuapp.com/chat/';

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

let currentMessages = 0;

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

    if (currentMessages != beskeder.length) {

        currentMessages = beskeder.length;

        const chatbox = document.getElementById('chatbox');
        const chatboxMessages = document.getElementById('chatboxMessages');

        chatboxMessages.innerHTML = '';
        for (const besked of beskeder) {
            chatboxMessages.innerHTML += `${besked.navn}: ${besked.tekst} (${besked.nr})<br>`;
        }


        chatbox.scrollTop = chatboxMessages.scrollHeight; // Scroll to bottom automaticaly
    }
}

// Set onclick for submit
const submit = document.getElementById('submit');
submit.onclick = () => submitPostChatMessage();

// Set enter clicked on tekst field
const tekst = document.getElementById('tekst');
tekst.addEventListener("keyup", function (event) {
    // TODO: Fix enter på alle rum
    if (chatrum.value !== 'alle rum' && event.keyCode === 13) { // Number 13 is the "Enter" key on the keyboard
        submit.click();
        // submitPostChatMessage();
    }
});

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